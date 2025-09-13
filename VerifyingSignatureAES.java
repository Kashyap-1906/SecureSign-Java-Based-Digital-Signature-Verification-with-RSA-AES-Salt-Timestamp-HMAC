String[] parts = digitalSignature.split("\\.");
String storedSignature = parts[0];
String storedTimestamp = parts[1];
String modifiedMessage = salt + storedTimestamp + message;
mac.init(secretKey);
byte[] expectedSignature = mac.doFinal(modifiedMessage.getBytes());
boolean isVerified = Arrays.equals(Base64.getDecoder().decode(storedSignature),
expectedSignature);
