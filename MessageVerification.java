String receivedSignature = receivedSignature;
String receivedTimestamp = receivedTimestamp;
String reconstructedMessage = salt + receivedTimestamp + message;
byte[] reconstructedHash = digest.digest(reconstructedMessage.getBytes());
Signature verificationSignature = Signature.getInstance("SHA256withRSA");
verificationSignature.initVerify(publicKey);
verificationSignature.update(reconstructedHash);
byte[] decodedSignature = Base64.getDecoder().decode(receivedSignature);
boolean isValid = verificationSignature.verify(decodedSignature);
