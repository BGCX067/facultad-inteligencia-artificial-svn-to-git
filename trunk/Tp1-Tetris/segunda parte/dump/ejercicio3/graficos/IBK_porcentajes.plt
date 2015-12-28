set xrange [0:35]
set yrange [50:100]
set xlabel "% ruido"
set ylabel "% instancias correctamente clasificadas"
set terminal png
set output "C:\\dump\\ejercicio3\\graficos\\IBK_porcentajes.png"
plot  "C:\\dump\\ejercicio3\\tablas\\IBK_porcentajes.txt" using 1:2 title 'Resultados' with linespoints