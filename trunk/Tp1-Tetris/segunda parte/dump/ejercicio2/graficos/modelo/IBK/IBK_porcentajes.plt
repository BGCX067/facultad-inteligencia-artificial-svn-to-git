set xrange [0:85]
set yrange [90:100]
set xlabel "% faltantes completado (con modelo simple)"
set ylabel "% instancias correctamente clasificadas (CV-10)"
set terminal png
set output "C:\\dump\\ejercicio2\\graficos\\modelo\\IBK\\IBK_porcentajes.png"
plot  "C:\\dump\\ejercicio2\\tablas\\modelo\\IBK_porcentajes.txt" using 1:2 title 'Resultados' with linespoints