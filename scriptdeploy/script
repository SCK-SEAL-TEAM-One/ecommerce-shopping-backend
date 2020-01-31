#!/etc/bash
#Deploy Script
scp -i $FILEPEM -r ecommerce-shopping-backend/target/shoppingcart-0.0.1-SNAPSHOT.jar ubuntu@ec2-52-77-209-133.ap-southeast-1.compute.amazonaws.com:/opt/

#Running Script
ssh -i $FILEPEM ubuntu@ec2-52-77-209-133.ap-southeast-1.compute.amazonaws.com

cd /opt/
kill -9 `cat processid.txt`
rm processid.txt

nohup java -jar shoppingcart-0.0.1-SNAPSHOT.jar > process.log 2>&1 &
echo $! > processid.txt
