set xrange [0:85]
set yrange [0:10]
set xlabel "% faltantes completado (con moda de la clase)"
set ylabel "Tamaño del árbol de decisión (en nodos)"
set terminal png
set output "C:\\dump\\ejercicio2\\graficos\\modaclase\\J48\\J48_tamanio_nodos.png"
plot  "C:\\dump\\ejercicio2\\tablas\\modaclase\\J48_tamanios.txt" using 1:2 title 'Resultados' with linespoints