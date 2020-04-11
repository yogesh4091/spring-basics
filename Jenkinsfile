pipeline {
    environment {
        PATH = 'C:\\Program Files\\Git\\usr\\bin;C:\\Program Files\\Git\\bin;${env.PATH}'
    agent any
    tools {
        maven 'mvn'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

         stage ('Test') {
                    steps {
                        echo 'Running tests'
                        sh 'mvn clean test'
                    }
                }

        stage ('Build') {
            steps {
                echo 'Build'
                sh 'mvn clean package'
            }
        }
    }
}