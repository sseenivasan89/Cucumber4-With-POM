pipeline {
  agent any
  stages {
    stage('DEV') {
      parallel {
        stage('DEV') {
          steps {
            bat 'mvn clean test'
          }
        }

        stage('QA') {
          steps {
            bat 'mvn clean test'
          }
        }

      }
    }

  }
}