String modifiedMessage = salt + timestamp + message;
MessageDigest digest = MessageDigest.getInstance("SHA-256");
byte[] hash = digest.digest(modifiedMessage.getBytes());
Signature signature = Signature.getInstance("SHA256withRSA");
signature.initSign(privateKey);
signature.update(hash);
byte[] digitalSignature = signature.sign();
String encodedSignature = Base64.getEncoder().encodeToString(digitalSignature);
