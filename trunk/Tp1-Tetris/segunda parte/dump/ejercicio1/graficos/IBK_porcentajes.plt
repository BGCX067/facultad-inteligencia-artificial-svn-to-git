set xrange [0:25]
set yrange [85:100]
set xlabel "Número de vecinos"
set ylabel "% instancias correctamente clasificadas"
set terminal png
set output "C:\\dump\\ejercicio1\\graficos\\IBK_porcentajes.png"
plot  "C:\\dump\\ejercicio1\\tablas\\IBK_porcentajes.txt" using 1:2 title 'Testing' with linespoints, \
 "C:\\dump\\ejercicio1\\tablas\\IBK_porcentajes.txt" using 1:3 title 'Training' with linespoints