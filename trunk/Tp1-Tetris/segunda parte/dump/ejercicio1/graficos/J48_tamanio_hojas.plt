set xrange [0:1]
set yrange [0:10]
set xlabel "Factor de confidencia"
set ylabel "Tamaño del árbol de decisión (en hojas)"
set terminal png
set output "C:\\dump\\ejercicio1\\graficos\\J48_tamanio_hojas.png"
plot  "C:\\dump\\ejercicio1\\tablas\\J48_tamanios.txt" using 1:2 title 'Resultados' with linespoints