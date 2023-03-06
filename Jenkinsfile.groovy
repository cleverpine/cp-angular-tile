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
    stage("Deployment (Artifactory)") {
      when {
        branch 'main'
      }

      environment {
          // NPM_CONFIG_REGISTRY = 'https://lht.app.lufthansa.com/artifactory/api/npm/npm-local/'
          NPM_CONFIG__AUTH = credentials('npm-publish-token')
          NPM_CONFIG_ALWAYS_AUTH = true
          NPM_CONFIG_EMAIL = 'hamtiebs@lht.dlh.de'
      }

      steps {
        script {
          sh """
            npm install
            npm run build-library
            cd dist/tile
            npm publish
          """
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
