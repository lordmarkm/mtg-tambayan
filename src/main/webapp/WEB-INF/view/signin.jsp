<!DOCTYPE html>
<html>
<head>
<title>Sign In</title>
</head>
<body>
  <form action="/signin/facebook" method="POST">
    <button type="submit">Sign in with Facebook</button>
    <input type="hidden" name="scope" value="email,user_friends" />
  </form>
</body>
</html>
