<?php
if(isset($_POST['username']) &&isset($_POST['email']) && isset($_POST['contact']) && isset($_POST['password'])){
    // Include the necessary files
    require_once "conn.php";
    require_once "validate.php";
    // Call validate, pass form data as parameter and store the returned value
    $user=validate($_POST['username']);


    $no=validate($_POST['contact']);

    $email = validate($_POST['email']);
    $password = validate($_POST['password']);
    // Create the SQL query string. We'll use md5() function for data security. It calculates and returns the MD5 hash of a string
    $sql ="INSERT INTO `user`(`user_id`, `username`, `email`, `contact`, `password`) VALUES ('','$user','$mail','$no','" . md5($password) . "')";
    // $sql = "insert into user values('','$email', '" . md5($password) . "')";
    // Execute the query. Print "success" on a successful execution, otherwise "failure".
    if(!$conn->query($sql)){
        echo "failure";
    }else{
        echo "success";   
    }
}
?>