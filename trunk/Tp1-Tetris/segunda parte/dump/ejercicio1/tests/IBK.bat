java weka.classifiers.lazy.IBk -t c:\dump\vote.arff -split-percentage 80 -K 1 -W 0 -A "weka.core.neighboursearch.LinearNNSearch -A \"weka.core.EuclideanDistance -R first-last\"" > c:\dump\ejercicio1\resultados\IBK\IBK_1.txt
java weka.classifiers.lazy.IBk -t c:\dump\vote.arff -split-percentage 80 -K 3 -W 0 -A "weka.core.neighboursearch.LinearNNSearch -A \"weka.core.EuclideanDistance -R first-last\"" > c:\dump\ejercicio1\resultados\IBK\IBK_3.txt
java weka.classifiers.lazy.IBk -t c:\dump\vote.arff -split-percentage 80 -K 5 -W 0 -A "weka.core.neighboursearch.LinearNNSearch -A \"weka.core.EuclideanDistance -R first-last\"" > c:\dump\ejercicio1\resultados\IBK\IBK_5.txt
java weka.classifiers.lazy.IBk -t c:\dump\vote.arff -split-percentage 80 -K 7 -W 0 -A "weka.core.neighboursearch.LinearNNSearch -A \"weka.core.EuclideanDistance -R first-last\"" > c:\dump\ejercicio1\resultados\IBK\IBK_7.txt
java weka.classifiers.lazy.IBk -t c:\dump\vote.arff -split-percentage 80 -K 9 -W 0 -A "weka.core.neighboursearch.LinearNNSearch -A \"weka.core.EuclideanDistance -R first-last\"" > c:\dump\ejercicio1\resultados\IBK\IBK_9.txt
java weka.classifiers.lazy.IBk -t c:\dump\vote.arff -split-percentage 80 -K 13 -W 0 -A "weka.core.neighboursearch.LinearNNSearch -A \"weka.core.EuclideanDistance -R first-last\"" > c:\dump\ejercicio1\resultados\IBK\IBK_13.txt
java weka.classifiers.lazy.IBk -t c:\dump\vote.arff -split-percentage 80 -K 21 -W 0 -A "weka.core.neighboursearch.LinearNNSearch -A \"weka.core.EuclideanDistance -R first-last\"" > c:\dump\ejercicio1\resultados\IBK\IBK_21.txt
@pause