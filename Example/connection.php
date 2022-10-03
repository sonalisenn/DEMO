<?php
$servername="localhost";
$mysql_user="root";
$mysql_pass="";
$dbname="tasty_app";
$conn=mysql_connect($servername,$mysql_user,$mysql_pass,$dbname);

if($conn){
echo("connection success");

}else{
echo("connection not success");
}

if($_SERVER['REQUEST_METHOD']=='POST'){
$user=$_POST['username'];

$mail=$_POST['email'];
$no=$_POST['contact'];
$pass=$_POST['password'];



$query = "INSERT INTO `user`(`user_id`, `username`, `email`, `contact`, `password`) VALUES ('$user','$mail','$no','$pass')";
if(mysqli_query($conn,$query)){
echo("Registered successfully !!");

}else{
    echo("Registered failed !!");
}

}else{
    echo("error in request method ");
}
?>