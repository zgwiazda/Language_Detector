import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Perceptron {
    public String label;
    public List<MyVector> vectors;
    public List<Double> weights;
    private double bias;
    public Perceptron(String label){
        this.label = label;
        vectors = new ArrayList<>();
        weights = new ArrayList<>();
        Random random = new Random();
        // Inicjalizacja wag losowymi wartościami z przedziału -1 do 1
        for (int i = 0; i < 26; i++) {
            weights.add(random.nextGaussian());
        }
        // Inicjalizacja biasu losową wartością z przedziału -1 do 1
        bias = random.nextGaussian();
    }

    public static int BinaryActivationFunction(double netInput) {
        return (netInput >= 0) ? 1 : 0;
    }
    public static double SigmoidActivationFunction(double netInput) {
        return 1.0 / (1.0 + Math.exp(-netInput));
    }
    public double DerivativeSigmoid(double output) {
        return output * (1 - output);
    }

    public double ActivationFunction(double netInput) {
        return netInput;
    }
    public void NormalizeVector(List<Double> vector) {
        double magnitude = 0.0;
        for (double value : vector) {
            magnitude += Math.pow(value, 2);
        }
        magnitude = Math.sqrt(magnitude);
        for (int i = 0; i < vector.size(); i++) {
            vector.set(i, vector.get(i) / magnitude);
        }
    }
    public void NormalizeWeights() {
        NormalizeVector(weights);
    }
    public void CreateVec(File file){
        List<Double> countLetters = new ArrayList<>();
        for(int i=0;i<26;i++){
            countLetters.add(i,0.0);
        }
        try {
            // Tworzymy obiekt FileReader do czytania z pliku
            FileReader fileReader = new FileReader(file);

            // Tworzymy obiekt BufferedReader do czytania linia po linii
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int charCode;

            // Czytamy znak po znaku z pliku, dopóki nie osiągniemy końca pliku
            while ((charCode = bufferedReader.read()) != -1) {
                // Konwertujemy kod znaku na znak i wykonujemy jakieś działania na nim
                char character = (char) charCode;
                Character.toLowerCase(character);


                // Zliczamy ilosc wystąpień każdej litery, pomijamy znaki i litery spoza alfabetu łacińskiego

                switch (character) {
                    case 'a':
                        // 1
                        double value0 = countLetters.get(0); // Pobieramy wartość z listy na indeksie 0
                        value0 += 1; // Zwiększamy wartość o 1
                        countLetters.set(0, value0); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście                        break;
                    case 'b':
                        // 2
                        double value1 = countLetters.get(1); // Pobieramy wartość z listy na indeksie 0
                        value1 += 1; // Zwiększamy wartość o 1
                        countLetters.set(1, value1); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'c':
                        // 3
                        double value2 = countLetters.get(2); // Pobieramy wartość z listy na indeksie 0
                        value2 += 1; // Zwiększamy wartość o 1
                        countLetters.set(2, value2); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'd':
                        // 4
                        double value3 = countLetters.get(3); // Pobieramy wartość z listy na indeksie 0
                        value3 += 1; // Zwiększamy wartość o 1
                        countLetters.set(3, value3); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'e':
                        // 5
                        double value4 = countLetters.get(4); // Pobieramy wartość z listy na indeksie 0
                        value4 += 1; // Zwiększamy wartość o 1
                        countLetters.set(4, value4); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'f':
                        // 6
                        double value5 = countLetters.get(5); // Pobieramy wartość z listy na indeksie 0
                        value5 += 1; // Zwiększamy wartość o 1
                        countLetters.set(5, value5); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'g':
                        // 7
                        double value6 = countLetters.get(6); // Pobieramy wartość z listy na indeksie 0
                        value6 += 1; // Zwiększamy wartość o 1
                        countLetters.set(6, value6); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'h':
                        // 8
                        double value7 = countLetters.get(7); // Pobieramy wartość z listy na indeksie 0
                        value7 += 1; // Zwiększamy wartość o 1
                        countLetters.set(7, value7); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'i':
                        // 9
                        double value8 = countLetters.get(8); // Pobieramy wartość z listy na indeksie 0
                        value8 += 1; // Zwiększamy wartość o 1
                        countLetters.set(8, value8); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'j':
                        // 10
                        double value9 = countLetters.get(9); // Pobieramy wartość z listy na indeksie 0
                        value9 += 1; // Zwiększamy wartość o 1
                        countLetters.set(9, value9); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'k':
                        // 11
                        double value10 = countLetters.get(10); // Pobieramy wartość z listy na indeksie 0
                        value10 += 1; // Zwiększamy wartość o 1
                        countLetters.set(10, value10); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'l':
                        // 12
                        double value11 = countLetters.get(11); // Pobieramy wartość z listy na indeksie 0
                        value11 += 1; // Zwiększamy wartość o 1
                        countLetters.set(11, value11); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'm':
                        // 13
                        double value12 = countLetters.get(12); // Pobieramy wartość z listy na indeksie 0
                        value12 += 1; // Zwiększamy wartość o 1
                        countLetters.set(12, value12); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'n':
                        // 14
                        double value13 = countLetters.get(13); // Pobieramy wartość z listy na indeksie 0
                        value13 += 1; // Zwiększamy wartość o 1
                        countLetters.set(13, value13); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'o':
                        // 15
                        double value14= countLetters.get(14); // Pobieramy wartość z listy na indeksie 0
                        value14 += 1; // Zwiększamy wartość o 1
                        countLetters.set(14, value14); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'p':
                        // 16
                        double value15 = countLetters.get(15); // Pobieramy wartość z listy na indeksie 0
                        value15 += 1; // Zwiększamy wartość o 1
                        countLetters.set(15, value15); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'q':
                        // 17
                        double value16 = countLetters.get(16); // Pobieramy wartość z listy na indeksie 0
                        value16 += 1; // Zwiększamy wartość o 1
                        countLetters.set(16, value16); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'r':
                        // 18
                        double value17 = countLetters.get(17); // Pobieramy wartość z listy na indeksie 0
                        value17 += 1; // Zwiększamy wartość o 1
                        countLetters.set(17, value17); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 's':
                        // 19
                        double value18 = countLetters.get(18); // Pobieramy wartość z listy na indeksie 0
                        value18 += 1; // Zwiększamy wartość o 1
                        countLetters.set(18, value18); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 't':
                        // 20
                        double value19 = countLetters.get(19); // Pobieramy wartość z listy na indeksie 0
                        value19 += 1; // Zwiększamy wartość o 1
                        countLetters.set(19, value19); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'u':
                        // 21
                        double value20 = countLetters.get(20); // Pobieramy wartość z listy na indeksie 0
                        value20 += 1; // Zwiększamy wartość o 1
                        countLetters.set(20, value20); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'v':
                        // 22
                        double value21 = countLetters.get(21); // Pobieramy wartość z listy na indeksie 0
                        value21 += 1; // Zwiększamy wartość o 1
                        countLetters.set(21, value21); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'w':
                        // 23
                        double value22 = countLetters.get(22); // Pobieramy wartość z listy na indeksie 0
                        value22 += 1; // Zwiększamy wartość o 1
                        countLetters.set(22, value22); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'x':
                        // 24
                        double value23 = countLetters.get(23); // Pobieramy wartość z listy na indeksie 0
                        value23 += 1; // Zwiększamy wartość o 1
                        countLetters.set(23, value23); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'y':
                        // 25
                        double value24 = countLetters.get(24); // Pobieramy wartość z listy na indeksie 0
                        value24 += 1; // Zwiększamy wartość o 1
                        countLetters.set(24, value24); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;
                    case 'z':
                        // 26
                        double value25 = countLetters.get(25); // Pobieramy wartość z listy na indeksie 0
                        value25 += 1; // Zwiększamy wartość o 1
                        countLetters.set(25, value25); // Przypisujemy zaktualizowaną wartość z powrotem do indeksu 0 w liście
                        break;

                    // Możesz dodać więcej case'ów dla innych wartości
                    default:
                        // Kod wykonywany, jeśli wyrażenie nie pasuje do żadnego przypadku
                }

                //zmiana
                /*for(MyVector vector: vectors){
                    NormalizeVector(vector.vec);
                }*/
            }


            // Zamykamy strumień czytania z pliku
            bufferedReader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        MyVector vector = new MyVector(countLetters);
        vectors.add(vector);
    }

    //y_predicted = perceptron_predict(freq_vector, weights, bias)
    //        update = (target - y_predicted)
    //        weights = [weights[i] + update * freq_vector[i] for i in range(len(freq_vector))]
    //        bias += update
    //

    public double Predict(MyVector vector){
        double y_predicted = 0;
            for(int i=0;i<vector.vec.size();i++){
                y_predicted+= vector.vec.get(i) * weights.get(i);
            }
        y_predicted += bias;
        return y_predicted;
    }

    public void Train(){

        double desired_accuracy = 0.95; // Przykładowa oczekiwana dokładność
        double current_accuracy =0 ; // Funkcja do obliczania dokładności


        while(current_accuracy < desired_accuracy){
            int correct_predictions = 0;
            for(MyVector vector: vectors){
                double y_predicted = Predict(vector);
                System.out.println("Predicted: "+y_predicted);

                double update = (1 - y_predicted);
                for (int i = 0; i < vector.vec.size(); i++) {
                    // Aktualizacja wag
                    double weight = weights.get(i);
                    double freq = vector.vec.get(i);
                    weights.set(i, weight + update * freq);
                }
                bias +=update;
                if (BinaryActivationFunction(y_predicted) == 1) {
                    correct_predictions++;
                }

            }
            current_accuracy = (double) correct_predictions / vectors.size();
            System.out.println("Current accuracy: "+current_accuracy);

        }
    }

    public void TrainWithSigmoid() {
        double learningRate = 0.1; // Przykładowy współczynnik uczenia
        double desired_accuracy = 0.95;
        double current_accuracy = 0;

        while (current_accuracy < desired_accuracy) {
            int correct_predictions = 0;
            for (MyVector vector : vectors) {
                double y_predicted = SigmoidActivationFunction(Predict(vector));
                System.out.println("Predicted: " + y_predicted);

                double error = 1 - y_predicted;
                double derivative = DerivativeSigmoid(y_predicted);
                for (int i = 0; i < vector.vec.size(); i++) {
                    double weight = weights.get(i);
                    double freq = vector.vec.get(i);
                    weights.set(i, weight + learningRate * error * derivative * freq);
                }
                bias += learningRate * error * derivative;

                if (y_predicted >= 0.5) {
                    correct_predictions++;
                }
            }
            NormalizeWeights();
            current_accuracy = (double) correct_predictions / vectors.size();
            System.out.println("Current accuracy: " + current_accuracy);
        }
    }

    public void Train(double threshold) {
        double learningRate = 0.01;
        double currentError = Double.MAX_VALUE;
        while (currentError > threshold) {
            currentError = 0.0;
            int correctPredictions = 0;
            for (MyVector vector : vectors) {
                double y_predicted = SigmoidActivationFunction(Predict(vector));
             //   System.out.println("Predicted: " + y_predicted);
                double error = 1 - y_predicted;
                currentError += Math.abs(error);
                for (int i = 0; i < vector.vec.size(); i++) {
                    double weight = weights.get(i);
                    double freq = vector.vec.get(i);
                    weights.set(i, weight + learningRate * error * freq);
                }
                bias += learningRate * error;
                if (Math.abs(error) < threshold) { // Sprawdź, czy błąd jest mniejszy niż próg
                    correctPredictions++;
                }
            }
            NormalizeWeights(); // Normalizacja wag po każdej iteracji
            currentError /= vectors.size(); // Obliczenie błędu średniego
          //  System.out.println("Current error: " + currentError);
        }
    }


}
