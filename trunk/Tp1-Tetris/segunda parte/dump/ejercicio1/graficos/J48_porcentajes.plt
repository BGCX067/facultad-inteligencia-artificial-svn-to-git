set xrange [0:1]
set yrange [90:100]
set xlabel "Factor de confidencia"
set ylabel "% instancias correctamente clasificadas"
set terminal png
set output "C:\\dump\\ejercicio1\\graficos\\J48_porcentajes.png"
plot  "C:\\dump\\ejercicio1\\tablas\\J48_porcentajes.txt" using 1:2 title 'Testing' with linespoints, \
 "C:\\dump\\ejercicio1\\tablas\\J48_porcentajes.txt" using 1:3 title 'Training' with linespoints