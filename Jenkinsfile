pipeline {
    agent any

    stages {
        stage('repo-checkout') {
            steps {
                git 'https://github.com/sseenivasan89/Cucumber4-With-POM.git'
            }
        }
         stage('mvn-build and test') {
            steps {
                 bat label: '', script: 'mvn clean verify'
            }
        }
        stage('generate cucumber report') {
            steps {
                 cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
            }
        }
       
        }
        
    }

