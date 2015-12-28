set xrange [0:35]
set yrange [0:20]
set xlabel "% ruido"
set ylabel "Tamaño del árbol de decisión (en hojas)"
set terminal png
set output "C:\\dump\\ejercicio3\\graficos\\J48_tamanio_hojas.png"
plot  "C:\\dump\\ejercicio3\\tablas\\J48_tamanios.txt" using 1:2 title 'Resultados' with linespoints