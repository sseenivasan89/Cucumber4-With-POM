pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven 3.6.3') {
                     sh 'mvn --version'
                }
            }
        }
    }
}