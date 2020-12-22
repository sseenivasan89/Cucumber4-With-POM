pipeline {
    agent any

    stages {
        stage('Maven Version') {
            steps {
                bat label: '', script: 'mvn -v'
            }
        }
        stage('Running Test') {
            steps {
                bat label: '', script: 'mvn clean test'
            }
        }
         stage('Report Generation') {
            steps {
                cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
            }
        }
        
    }
}