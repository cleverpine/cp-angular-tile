#!groovy

pipeline {
  agent {
    label 'node16'
  }

  options {
    buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10'))
    disableConcurrentBuilds()
  }

  stages {
    stage("Build") {
      when {
        branch 'main'
      }

      steps {
        script {
          sh """
            npm install
            npm run build-library
          """
        }
      }
    }

    stage("Deployment (Artifactory)") {
      when {
        branch 'main'
      }

      steps {
        script {
          dir("./dist/tile") {
            configFileProvider([configFile(fileId: 'npm_publish_settings', targetLocation: '.npmrc')]) {
              sh "npm publish"
            }
          }
        }
      }
    }
  }

  post {
    always {
      script {
        currentBuild.result = currentBuild.result ?: 'SUCCESS'
        notifyBitbucket()
      }
    }
  }
}
