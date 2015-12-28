java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 2-last,1 -o C:\dump\ejercicio2\\modelos\vote_1.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_1.arff -d C:\dump\ejercicio2\modelos\vote_1.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_1.model -p 17 -T C:\dump\ejercicio2\\modelos\vote_1.arff > C:\dump\ejercicio2\modelos\predic_1.txt
del C:\dump\ejercicio2\modelos\vote_1.model
del C:\dump\ejercicio2\modelos\vote_1.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-1,3-last,2 -o C:\dump\ejercicio2\modelos\vote_2.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_2.arff -d C:\dump\ejercicio2\modelos\vote_2.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_2.model -p 17 -T C:\dump\ejercicio2\modelos\vote_2.arff > C:\dump\ejercicio2\modelos\predic_2.txt

del C:\dump\ejercicio2\modelos\vote_2.model
del C:\dump\ejercicio2\modelos\vote_2.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-2,4-last,3 -o C:\dump\ejercicio2\modelos\vote_3.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_3.arff -d C:\dump\ejercicio2\modelos\vote_3.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_3.model -p 17 -T C:\dump\ejercicio2\modelos\vote_3.arff > C:\dump\ejercicio2\modelos\predic_3.txt

del C:\dump\ejercicio2\modelos\vote_3.model
del C:\dump\ejercicio2\modelos\vote_3.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-3,5-last,4 -o C:\dump\ejercicio2\modelos\vote_4.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_4.arff -d C:\dump\ejercicio2\modelos\vote_4.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_4.model -p 17 -T C:\dump\ejercicio2\modelos\vote_4.arff > C:\dump\ejercicio2\modelos\predic_4.txt

del C:\dump\ejercicio2\modelos\vote_4.model
del C:\dump\ejercicio2\modelos\vote_4.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-4,6-last,5 -o C:\dump\ejercicio2\modelos\vote_5.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_5.arff -d C:\dump\ejercicio2\modelos\vote_5.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_5.model -p 17 -T C:\dump\ejercicio2\modelos\vote_5.arff > C:\dump\ejercicio2\modelos\predic_5.txt

del C:\dump\ejercicio2\modelos\vote_5.model
del C:\dump\ejercicio2\modelos\vote_5.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-5,7-last,6 -o C:\dump\ejercicio2\modelos\vote_6.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_6.arff -d C:\dump\ejercicio2\modelos\vote_6.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_6.model -p 17 -T C:\dump\ejercicio2\modelos\vote_6.arff > C:\dump\ejercicio2\modelos\predic_6.txt

del C:\dump\ejercicio2\modelos\vote_6.model
del C:\dump\ejercicio2\modelos\vote_6.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-6,8-last,7 -o C:\dump\ejercicio2\modelos\vote_7.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_7.arff -d C:\dump\ejercicio2\modelos\vote_7.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_7.model -p 17 -T C:\dump\ejercicio2\modelos\vote_7.arff > C:\dump\ejercicio2\modelos\predic_7.txt

del C:\dump\ejercicio2\modelos\vote_7.model
del C:\dump\ejercicio2\modelos\vote_7.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-7,9-last,8 -o C:\dump\ejercicio2\modelos\vote_8.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_8.arff -d C:\dump\ejercicio2\modelos\vote_8.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_8.model -p 17 -T C:\dump\ejercicio2\modelos\vote_8.arff > C:\dump\ejercicio2\modelos\predic_8.txt

del C:\dump\ejercicio2\modelos\vote_8.model
del C:\dump\ejercicio2\modelos\vote_8.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-8,10-last,9 -o C:\dump\ejercicio2\modelos\vote_9.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_9.arff -d C:\dump\ejercicio2\modelos\vote_9.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_9.model -p 17 -T C:\dump\ejercicio2\modelos\vote_9.arff > C:\dump\ejercicio2\modelos\predic_9.txt

del C:\dump\ejercicio2\modelos\vote_9.model
del C:\dump\ejercicio2\modelos\vote_9.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-9,11-last,10 -o C:\dump\ejercicio2\modelos\vote_10.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_10.arff -d C:\dump\ejercicio2\modelos\vote_10.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_10.model -p 17 -T C:\dump\ejercicio2\modelos\vote_10.arff > C:\dump\ejercicio2\modelos\predic_10.txt

del C:\dump\ejercicio2\modelos\vote_10.model
del C:\dump\ejercicio2\modelos\vote_10.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-10,12-last,11 -o C:\dump\ejercicio2\modelos\vote_11.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_11.arff -d C:\dump\ejercicio2\modelos\vote_11.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_11.model -p 17 -T C:\dump\ejercicio2\modelos\vote_11.arff > C:\dump\ejercicio2\modelos\predic_11.txt

del C:\dump\ejercicio2\modelos\vote_11.model
del C:\dump\ejercicio2\modelos\vote_11.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-11,13-last,12 -o C:\dump\ejercicio2\modelos\vote_12.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_12.arff -d C:\dump\ejercicio2\modelos\vote_12.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_12.model -p 17 -T C:\dump\ejercicio2\modelos\vote_12.arff > C:\dump\ejercicio2\modelos\predic_12.txt

del C:\dump\ejercicio2\modelos\vote_12.model
del C:\dump\ejercicio2\modelos\vote_12.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-12,14-last,13 -o C:\dump\ejercicio2\modelos\vote_13.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_13.arff -d C:\dump\ejercicio2\modelos\vote_13.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_13.model -p 17 -T C:\dump\ejercicio2\modelos\vote_13.arff > C:\dump\ejercicio2\modelos\predic_13.txt

del C:\dump\ejercicio2\modelos\vote_13.model
del C:\dump\ejercicio2\modelos\vote_13.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-13,15-last,14 -o C:\dump\ejercicio2\modelos\vote_14.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_14.arff -d C:\dump\ejercicio2\modelos\vote_14.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_14.model -p 17 -T C:\dump\ejercicio2\modelos\vote_14.arff > C:\dump\ejercicio2\modelos\predic_14.txt

del C:\dump\ejercicio2\modelos\vote_14.model
del C:\dump\ejercicio2\modelos\vote_14.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-14,16-last,15 -o C:\dump\ejercicio2\modelos\vote_15.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_15.arff -d C:\dump\ejercicio2\modelos\vote_15.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_15.model -p 17 -T C:\dump\ejercicio2\modelos\vote_15.arff > C:\dump\ejercicio2\modelos\predic_15.txt

del C:\dump\ejercicio2\modelos\vote_15.model
del C:\dump\ejercicio2\modelos\vote_15.arff

java weka.filters.unsupervised.attribute.Reorder -i C:\dump\ejercicio2\vote.arff -R 1-15,17-last,16 -o C:\dump\ejercicio2\modelos\vote_16.arff
java weka.classifiers.trees.J48 -t C:\dump\ejercicio2\modelos\vote_16.arff -d C:\dump\ejercicio2\modelos\vote_16.model -C 0.25 -M 2
java weka.classifiers.trees.J48 -l C:\dump\ejercicio2\modelos\vote_16.model -p 17 -T C:\dump\ejercicio2\modelos\vote_16.arff > C:\dump\ejercicio2\modelos\predic_16.txt

del C:\dump\ejercicio2\modelos\vote_16.model
del C:\dump\ejercicio2\modelos\vote_16.arff

@pause
