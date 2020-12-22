pipeline {
  agent any
  stages {
    stage('Maven Version') {
      parallel {
        stage('Maven Version') {
          steps {
            bat 'mvn -v'
          }
        }

        stage('Java Version') {
          steps {
            bat 'java -version'
          }
        }

      }
    }

    stage('Running Test') {
      steps {
        bat 'mvn clean test'
      }
    }

    stage('Report Generation') {
      steps {
        cucumber(failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1)
      }
    }

  }
}