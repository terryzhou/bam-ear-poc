
EAR_PATH="./ear/target/bampoc-ear-sample-1.0.0-SNAPSHOT.ear"
TIMESTAMP=`date +%Y-%m-%d_%H-%M-%S`

echo "Backup ear file to ${EAR_PATH}.${TIMESTAMP} ..."
cp ${EAR_PATH} ${EAR_PATH}.${TIMESTAMP}

rm -fr BamSeverCloud.ear

unzip ${EAR_PATH} -d tmp
cd tmp
sed -i '' '/<singleton-service>/,/<\/singleton-service>/d' ./META-INF/weblogic-application.xml
zip -r BamSeverCloud.ear *
mv BamSeverCloud.ear ../
cd ..
rm -fr tmp
