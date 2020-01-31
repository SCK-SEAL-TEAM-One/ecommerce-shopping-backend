#!/etc/bash

cd /opt/
kill -9 `cat processid.txt`
rm processid.txt

nohup java -jar shoppingcart-0.0.1-SNAPSHOT.jar > process.log 2>&1 &
echo $! > processid.txt
