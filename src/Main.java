import java.io.File;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String directoryPathTraining = "/Users/zuziagwiazda/IdeaProjects/NOI_2/TRENINGOWE"; // Ścieżka do głównego folderu, w którym znajdują się foldery z językami
        String directoryPathTesting = "/Users/zuziagwiazda/IdeaProjects/NOI_2/TESTOWE"; // Ścieżka do głównego folderu, w którym znajdują się foldery z językami


        FolderTraversal folderTraversalTraining = new FolderTraversal();
        folderTraversalTraining.traverseDirectory(new File(directoryPathTraining));

        //testowanie poprawnie wpisanych wartosci w wektory
     /*   for(Perceptron p: folderTraversalTraining.perceptronList){
            System.out.println(p.label);
            for(MyVector v: p.vectors){
                System.out.print("{");
                for(Double i: v.vec){
                    System.out.print(i+", ");
                }
                System.out.print("}");
                System.out.println("");
            }
        }*/

        for(Perceptron perceptron : folderTraversalTraining.perceptronList){
            perceptron.Train(0.0001);
        }

        FolderTraversal folderTraversalTesting = new FolderTraversal();
        folderTraversalTesting.traverseDirectoryTestingGroup(new File(directoryPathTesting));

        //pomieszanie testowych wektorow
        Collections.shuffle(folderTraversalTesting.vectorListTesting);
        double correct_predictions = 0;
        double all_predictions = folderTraversalTesting.vectorListTesting.size();

        for (MyVector vector : folderTraversalTesting.vectorListTesting) {
            double maxPrediction = Double.NEGATIVE_INFINITY; // Inicjalizacja maksymalnej predykcji jako ujemnej nieskończoności
            String predictedLanguage = "";

            // Iteracja przez perceptrony w celu uzyskania predykcji dla danego wektora
            for (Perceptron perceptron : folderTraversalTraining.perceptronList) {
                double prediction = perceptron.Predict(vector); // Pobranie predykcji dla danego perceptronu
                if (prediction > maxPrediction) { // Jeśli obecna predykcja jest większa niż maksymalna predykcja dotychczas
                    maxPrediction = prediction; // Ustaw maksymalną predykcję na obecną predykcję
                    predictedLanguage = perceptron.label; // Przypisz etykietę języka odpowiadającą perceptronowi z maksymalną predykcją
                }
            }

            // Wyświetlenie predykcji
            System.out.println("Actual language: " + vector.language + ", predicted language: " + predictedLanguage);

            // Sprawdzenie poprawności predykcji
            if (predictedLanguage.equals(vector.language)) {
                correct_predictions++;
            }
        }

// Obliczenie procentu poprawnych predykcji
        double summary = (correct_predictions / all_predictions) * 100;
        System.out.println("Percent of correct predictions: " + summary + "%");

        //niepoprawne
/*
        double correct_predictions = 0;
        double all_predictions = folderTraversalTesting.vectorListTesting.size();

        for(MyVector vector: folderTraversalTesting.vectorListTesting){
            HashMap<Double, String> predictions = new HashMap<>();
            double L1 = 0;
            double L2 = 0;
            double L3 = 0;
            int counter = 1;
            String predictedLanguage = "";

            for(Perceptron perceptron: folderTraversalTraining.perceptronList){
                if(counter ==1){
                    L1 = perceptron.Predict(vector);
                    predictions.put(L1,perceptron.label);
                }
                if(counter ==2){
                    L2 = perceptron.Predict(vector);
                    predictions.put(L2,perceptron.label);
                }
                if(counter ==3){
                    L3 = perceptron.Predict(vector);
                    predictions.put(L3,perceptron.label);
                }
                counter++;
            }
            if(L1>L2){
                predictedLanguage = predictions.get(L1);
            }
            if(L1>L3){
                predictedLanguage = predictions.get(L1);
            }

            if(L2>L1){
                predictedLanguage = predictions.get(L2);
            }
            if(L2>L3){
                predictedLanguage = predictions.get(L2);
            }
            if(L3>L1){
                predictedLanguage = predictions.get(L3);
            }
            if(L3>L2){
                predictedLanguage = predictions.get(L3);
            }
            System.out.print("Actual language: "+vector.language+", predicted language: "+predictedLanguage);
            System.out.println("");
            if(predictedLanguage.equals(vector.language)){
                correct_predictions++;
            }
        }

        double summary = (correct_predictions/all_predictions) *100;
        System.out.println("Percent of correct predictions: "+summary+"%");
      /*  for(MyVector vector: folderTraversalTesting.vectorListTesting){
            System.out.println(vector.language);
                for(double i : vector.vec) {
                    System.out.print(i + ", ");
                }
                System.out.print("}");
                System.out.println("");

        }*/


    }
}