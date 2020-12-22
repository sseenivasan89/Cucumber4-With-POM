pipeline {
    agent any

    stages {
        stage('Maven Version') {
            steps {
                bat label: '', script: 'mvn -v'
            }
        }
        stage('Deploy') {
            steps {
                bat label: '', script: 'mvn clean test'
            }
        }
    }
}
