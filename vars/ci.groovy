def call() {
  pipeline {

    agent {
      label ' workstation  '
    }

    stages {

      stage('Compile/Build') {
        steps {
          script  {
            common.compile()
          }
        }
      }

      stage('Unit Tests') {
        steps {
          echo 'unit tests'
        }
      }

      stage('Quality Control') {
        steps {
          echo 'quality control'
        }
      }

      stage('Upload code to Centralized Place') {
        steps {
          echo 'upload'
        }
      }


    }

  }
}