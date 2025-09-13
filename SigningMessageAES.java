timestamp = new SimpleDateFormat("hh:mm:ss a").format(new Date()); String
modifiedMessage = salt + timestamp + message;
Mac mac = Mac.getInstance("HmacSHA256");
mac.init(secretKey);
byte[] signature = mac.doFinal(modifiedMessage.getBytes());
String digitalSignature = Base64.getEncoder().encodeToString(signature) + "." + timestamp;
