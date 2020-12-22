pipeline {
    agent any

    stages {
        stage('Maven Version') {
            steps {
                bat label: '', script: 'mvn -v'
            }
        }
        stage('Clone Repo') {
            steps {
                 git credentialsId: 'e2232cbd-fbae-4c0d-b289-cb2e5e0bff91', url: 'https://github.com/sseenivasan89/Cucumber4-With-POM.git'
            }
        }
        stage('Deploy') {
            steps {
                 bat label: '', script: 'mvn clean test'
            }
        }
    }
}