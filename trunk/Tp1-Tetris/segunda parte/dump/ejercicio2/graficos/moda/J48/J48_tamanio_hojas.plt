set xrange [0:85]
set yrange [0:10]
set xlabel "% faltantes completado (con moda)"
set ylabel "Tamaño del árbol de decisión (en hojas)"
set terminal png
set output "C:\\dump\\ejercicio2\\graficos\\moda\\J48\\J48_tamanio_hojas.png"
plot  "C:\\dump\\ejercicio2\\tablas\\moda\\J48_tamanios.txt" using 1:2 title 'Resultados' with linespoints