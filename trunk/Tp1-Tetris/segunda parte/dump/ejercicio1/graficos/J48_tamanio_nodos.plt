set xrange [0:1]
set yrange [0:20]
set xlabel "Factor de confidencia"
set ylabel "Tamaño del árbol de decisión (en nodos)"
set terminal png
set output "C:\\dump\\ejercicio1\\graficos\\J48_tamanio_nodos.png"
plot  "C:\\dump\\ejercicio1\\tablas\\J48_tamanios.txt" using 1:3 title 'Resultados' with linespoints