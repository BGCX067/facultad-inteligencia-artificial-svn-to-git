set xrange [0:20]
set yrange [90:100]
set xlabel "hiddenLayers"
set ylabel "% instancias correctamente clasificadas"
set key 6.30466, 91.7904
set terminal png
set output "C:\\dump\\ejercicio1\\graficos\\MultilayerPerceptron_porcentajes.png"
plot  "C:\\dump\\ejercicio1\\tablas\\MultilayerPerceptron_porcentajes.txt" using 1:2 title 'Testing' with linespoints, \
 "C:\\dump\\ejercicio1\\tablas\\MultilayerPerceptron_porcentajes.txt" using 1:3 title 'Training' with linespoints