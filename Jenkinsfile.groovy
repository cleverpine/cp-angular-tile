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
          configFileProvider([configFile(fileId: 'npm_publish_settings', targetLocation: './dist/tile/.npmrc')]) {
            sh """
              cd dist/tile
              npm publish
            """
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
