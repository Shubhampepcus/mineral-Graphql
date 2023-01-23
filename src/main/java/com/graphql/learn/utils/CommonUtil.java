package com.graphql.learn.utils;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.CaseFormat;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.gson.Gson;

/**
 * To keep some common util methods 
 * 
 * @author Shubham.Solanki
 * @since 2020-01-06
 *
 */
public class CommonUtil {
    
    private static Logger logger = LoggerFactory.getLogger(CommonUtil.class);

////    /**
////     * This will return current date and time in UTC
////     * 
////     * @return
////     */
////    public static String getTodayInUTC() {
////        DateTimeFormatter format = DateTimeFormatter.ofPattern(VALID_FORMAT_YYYY_MM_DD_HH_MM_SS);
////        ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneOffset.UTC);
////        return format.format(utcDateTime);
////    }
////    
////    /**
////     * This function returns the first object which is instance of class cls from array of objects objs.
////     * If no objects from objs is instance of cls then returns null.
////     * 
////     * @param cls
////     * @param objs
////     * @return
////     */
////    public static Object getObjectForClass(Class<?> cls, Object... objs) {
////        for (Object o : objs) {
////            if (cls.isInstance(o)) {
////                return o;
////            }
////        }
////        return null;
////    }
////    
////    /**
////     * Find all string in array is empty
////     * 
////     * @param array
////     * @return boolean
////     */
////    public static boolean isArrayOnlyEmptyString(String[] values) {
////        for(int i=0;i<values.length; i++){
////            if (!values[i].isEmpty()) {
////                return false;
////            }
////        }
////        return true;
////    }
//    
    /**
     * 
     * @return
     */
    public static Long getNowInMiliseconds() {
        Date now = new Date();
        return now.getTime();
    }
    
//    /**
//     * Current time in timestamp.
//     * 
//     * @return
//     */
//    public static Timestamp getNowInTimestamp() {
//        return new Timestamp(getNowInMiliseconds());
//    }
//
//    /**
//     * Current seconds time in timestamp.
//     *
//     * @return
//     */
//    public static Timestamp getSecondsInTimestamp(String seconds) {
//        Long time = Long.parseLong(String.valueOf(seconds));
//        return new Timestamp(time * 1000);
//    }
//    
//    /**
//     * Generates and returns a hash.
//     * 
//     * @param value
//     * @return
//     */
//    public static String generateHashedValue(Integer value) {
//        long microTime = System.currentTimeMillis();
//        String companyIdWithMicroTime = String.valueOf(microTime + value).replace(" ", "");
//        String encodedString = Base64.getEncoder().encodeToString(companyIdWithMicroTime.getBytes());
//        String reversedString = StringUtils.reverse(encodedString.replace("=", ""));
//        return reversedString.toUpperCase();
//    }
//    
//    /**
//     * Get the value of requested field in Json String
//     * 
//     * @param requestJson
//     * @param field
//     * @return
//     */
//    @Loggable(value=Loggable.DEBUG)
//    public static String getFieldValue(String requestJson, String field) {
//        
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            // convert JSON string to Map
//            JsonNode node = mapper.readTree(requestJson);
//            return node.get(field).asText().trim();
//        } catch (IOException e) { 
//            throw new RuntimeException(e);
//        }
//    }
//    
//    /**
//     * Returns true if Json String has the requested field
//     * 
//     * @param requestJson
//     * @return
//     */
//    @Loggable(value=Loggable.DEBUG)
//    public static boolean containsField(String requestJson, String field) {
//       
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            // convert JSON string to Map
//            JsonNode node = mapper.readTree(requestJson);
//            return (node.has(field)) ? true : false;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    
//    /**
//     * To get the field value if field name exists in request json.
//     * 
//     * @param requestJson
//     * @param fieldName
//     * @return
//     */
//    @Loggable(value=Loggable.DEBUG)
//    public static String getFieldValueIfExists(String requestJson, String fieldName) {
//        
//        String fieldValue = null;
//        
//        if (containsField(requestJson, fieldName)) {
//            fieldValue = getFieldValue(requestJson, fieldName);
//        }
//        return fieldValue;
//    }
//    
//    /**
//     * To get the field value if field name exists in request json.
//     * 
//     * @param requestJson
//     * @param fieldName
//     * @return
//     */
//    @Loggable(value=Loggable.DEBUG)
//    public static String getInnerFieldValue(String requestJson, String fieldName, String innerField) {
//        String value = null;
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//           JsonNode node = objectMapper.readValue(requestJson, JsonNode.class);
//           JsonNode fieldNode = node.get(fieldName);
//           
//           if(StringUtils.isBlank(innerField)) {
//               return objectMapper.writeValueAsString(fieldNode);
//           }
//
//           if(null != fieldNode && null != fieldNode.get(innerField)) {
//               value = fieldNode.get(innerField).asText().trim();
//           }
//
//        } catch (IOException e) {
//           e.printStackTrace();
//        }
//        return value;
//     }
//    
//    /**
//     * To get JSONObject from a json string
//     * 
//     * @param jsonString
//     * @return
//     * @throws JSONException
//     */
//    public static JSONObject getJSONObject(String jsonString) throws JSONException {
//        return new JSONObject(jsonString);
//    }
//    
//    /**
//     * Convert jsonArray into List<String>
//     * 
//     * @param jsonString
//     * @return
//     * @throws JSONException 
//     */
//    public static List<String> convertJSONArrayToStringList(String jsonString) throws JSONException{
//        JSONArray jsonArray = new JSONArray(jsonString);
//        int length = jsonArray.length();
//        List<String> data = new ArrayList<String>(); 
//        for (int i = 0; i < length; i++) {
//            data.add(jsonArray.optString(i));
//        }
//        return data;
//    }
//    
//    /**
//     * To get json string
//     * 
//     * @param object
//     * @return
//     */
//    public static String getJsonString(Object object) {
//        return new Gson().toJson(object);
//    }
//
//    /**
//     * Get the value of requested field in Json String
//     *
//     * @param requestJson
//     * @return
//     */
//    @Loggable(value=Loggable.DEBUG)
//    public static JsonNode getJsonFromString(String requestJson) {
//        try {
//            return new ObjectMapper().readTree(requestJson);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * validate phone number
//     * @param phoneNumber
//     * @param region
//     */
//    public static void validatePhoneNumber(String phoneNumber, String region) {
//        /*try {
//            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
//            PhoneNumber number = phoneNumberUtil.parse(phoneNumber, region);
//            
//            if (!isValidPhoneNumberLength(number, phoneNumber) || !phoneNumberUtil.isPossibleNumber(number)) {
//                throw ApplicationException.createBadRequest(APIErrorCodes.INVALID_PHONE_NUMBER, phoneNumber);
//            }
//        } catch (NumberParseException ne) {
//            throw ApplicationException.createBadRequest(APIErrorCodes.INVALID_PHONE_NUMBER, phoneNumber);
//        }*/
//        if (!StringUtils.isEmpty(phoneNumber) && (phoneNumber.length() < 10 || phoneNumber.length() > 25)) {
//            throw ApplicationException.createBadRequest(APIErrorCodes.INVALID_PHONE, phoneNumber);
//        }
//    }
//
//    /**
//     * Get tempID column value for Company entity.
//     * 
//     * @return
//     */
//    public static String getTempId() {
//        Calendar cal = Calendar.getInstance();
//        long currentTime = cal.getTime().getTime();
//        return String.valueOf(currentTime);
//    }
//    
//    /**
//     * Generate Custom sized Alpha numeric hex string
//     * 
//     * @param size
//     * @return
//     */
//    public static String generateRandomAlphanumericHexString(Integer size) {
//        Random r = new Random();
//        StringBuffer sb = new StringBuffer();
//        while(sb.length() < size){
//            sb.append(Integer.toHexString(r.nextInt()));
//        }
//
//        return sb.toString().substring(0, size);
//    }
//    
//    /**
//     * 
//     * @return
//     */
//    public static Integer getNowInMiliseconds_Integer() {
//        return (int) (new Date().getTime()/1000L);
//    }
//
//    /**
//     * Get Total Company Size
//     * from all the locations
//     * 
//     * @param locationList
//     * @return
//     */
//    public static String getTotalCompanySize(List<Location> locationList) {
//        
//        if (!CollectionUtils.isEmpty(locationList)) {
//            Set<Location> locations = locationList.stream().collect(Collectors.toSet());// To remove duplicate location objects 
//            // Get sum of all the employee counts from all the locations
//            Integer totalCompanySize = locations.stream()
//                                                .filter(location -> location.getEmployeeCount() != null)
//                                                .mapToInt(location -> location.getEmployeeCount())
//                                                .sum();
//            if (totalCompanySize != null && totalCompanySize != 0) {
//                return String.valueOf(totalCompanySize);
//            }
//        }
//        return null;    
//    }
//    
//    /**
//     * Converts any char at particular
//     * index to upper case in a given
//     * string 
//     * 
//     * @param string
//     * @param index
//     * @return
//     */
//    public static String convertCharToUpperCase(String string, int index) {
//        return new StrBuilder(string)
//                      .setCharAt(index, Character.toUpperCase(string.charAt(index)))
//                      .toString();
//    }
//    
//    /**
//     * Format a date in specified pattern. 
//     * 
//     * @return formatted date in string formate
//     */
//    public static String formatDate(String pattern) {
//        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
//        String formattedDate = formatter.format(new Date());
//        return formattedDate;
//    }
//    
//    /**
//     * Spilt string value and return value for a particular index.
//     * 
//     * @param string
//     * @param spiltBy
//     * @param index
//     * @return
//     */
//    public static String spiltString(String string, String spiltBy, int index) {
//        String[] split = string.split(spiltBy);
//        return split[index];
//    }
//    
//    /**
//     * Get File Object from MultipartFile Object
//     * 
//     * @param fileToUpload
//     * @return
//     * @throws IOException
//     */
//    public static File getFileFromMultipartObject(MultipartFile fileToUpload) throws IOException {
//        File file = new File(fileToUpload.getOriginalFilename());
//        FileUtils.copyInputStreamToFile(fileToUpload.getInputStream(), file);
//        return file;
//    }
//    
//    /**
//     * Date in integer.
//     * 
//     * @param date
//     * @return
//     */
//    public static Long getDateInMilliseconds(Date date) {
//        return  date.getTime();
//    }
//    
//    /**
//     * Get UUID
//     * 
//     * @return
//     */
//    public static String getUuId() {
//        return UUID.randomUUID().toString().replace(DASH, EMPTY_STRING);
//    }
//    
//    /**
//     * Get image file dimensions
//     * 
//     * @param imgFile
//     * @return
//     */
//    public static Dimension  getImageDimension(File imgFile) {
//        BufferedImage readImage = null;
//        Dimension d = null;
//
//        try {
//            readImage = ImageIO.read(imgFile);
//            int height = readImage.getHeight();
//            int width = readImage.getWidth();
//            d = new Dimension(width, height);
//        } catch (Exception e) {
//            readImage = null;
//        }
//        return d;
//    }
//    
//    /**
//     * Generate 5 digit random number
//     * 
//     * @return
//     */
//    public static Integer getRandomNumber() {
//        Random rnd = new Random();
//        Integer number = rnd.nextInt(99999);
//        return number;
//    }
//    
//    /**
//     * Method to validate url
//     * 
//     * @param websiteUrl
//     */
//    public static void validateURL(String websiteUrl) {
//        try {
//            new URL(websiteUrl);
//        } catch (MalformedURLException e) {
//            throw ApplicationException.createBadRequest(APIErrorCodes.INVALID_URL, websiteUrl);
//        }
//    }
//    
//    /**
//     * Method to convert time with UTC time zone
//     * 
//     * @param time
//     * @return
//     */
//    public static String convertTimeToUTCTimeZone(long time) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
//        cal.setTimeInMillis(time);
//        return (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH)  + "/" + cal.get(Calendar.YEAR);
//
//    }
//    
//    /**
//     * Method to next or previous date
//     * 
//     * @param day
//     * @return
//     */
//    public static Date getDateByDay(int day) {
//        Calendar date = Calendar.getInstance();
//        date.set(Calendar.HOUR_OF_DAY, 0);
//        date.set(Calendar.MINUTE, 0);
//        date.set(Calendar.SECOND, 0);
//        date.set(Calendar.MILLISECOND, 0);
//        date.add(Calendar.DAY_OF_MONTH, day);
//        return date.getTime();
//    }
//    
//    /**
//     * Parse date with given pattern
//     * 
//     * @param date
//     * @param pattern
//     * 
//     * @return String
//     */
//    public static String formatDate(Date date, String pattern) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        return simpleDateFormat.format(date);
//    }
//    
//    /**
//     * Parse String date into date with given pattern
//     * 
//     * @param date
//     * @param pattern
//     * 
//     * @return Date
//     */
//    public static Date parseDate(String date, String pattern) {
//        try {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        return simpleDateFormat.parse(date);
//        } catch (ParseException e) {
//            return null;
//        }
//    }
//    
//    /**
//     * Transform a timestamp string based on ISO 8601 Date Format to UnixTime Integer
//     * 
//     * @param timestamp
//     * @return
//     */
//    public static Long parseToUnixTime(String date, String pattern) {
//        Date dt = parseDate(date, pattern);
//        if (dt == null) {
//            return 0l;
//        }
//        long epoch = dt.getTime();
//        return epoch / 1000;
//    }
//    
//    /**
//     * Checks if a node is not empty.
//     *
//     * @param jsonNode
//     * @return true or false
//     * @author Chetan.Jain
//     * @since 2020-09-02
//     */
//    public static boolean isNotEmptyJsonNode(JsonNode jsonNode) {
//        return jsonNode != null && jsonNode.size() > 0;
//    } 
//    
//    /**
//    * Parse String date into date with month name
//    *
//     * @param inputDate
//     * @return Date
//     */
//    public static String parseDateWithMonthNameAndDayOrdinalSuffix(String inputDate) {
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat(MONTH_DATE_YEAR_FORMAT, Locale.ENGLISH);
//            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
//            Date date = sdf.parse(inputDate);
//            return dateFormat.format(date);
//        } catch (ParseException e) {
//            return null;
//        }
//    }
//    
//    /**
//     * @return
//     */
//    public static Long getYesterdayInMiliseconds(){
//        return getNowInMiliseconds() - 24*60*60*1000;
//   }
//    
//    /**
//     * @return
//     */
//    public static Long getDayBeforeAWeekInMiliseconds() {
//        return getNowInMiliseconds() - 7*24*60*60*1000;
//    }
//
//    public static Long getDayBeforeAFortnightInMiliseconds() {
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
//        cal.add(Calendar.DATE, -14);
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        return cal.getTimeInMillis();
//    }
//
//    public static Long getTimeBeforeAWeekInMiliseconds() {
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
//        cal.add(Calendar.DATE, -7);
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        return cal.getTimeInMillis();
//    }
//
//    /**
//    * get Number with ordinal suffix
//    *
//    * @param number
//    * @return String
//    */
//    public static String getNumberWithOrdinalSuffix(int number) {
//        if (number >= 11 && number <= 13) {
//            return number + "th";
//    }
//        switch (number % 10) {
//        case 1:
//            return number + "st";
//        case 2:
//            return number + "nd";
//        case 3:
//            return number + "rd";
//        default:
//            return number + "th";
//        }
//    }
//    
//    /**
//    * get Unix timestamp based on date and its pattern
//    *
//    * @param date
//    * @param pattern
//    * @return Long
//    */
//    public static Long getTimeInMillisByDateWithPattern(String date, String pattern) {
//        try {
//            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
//            calendar.setTime(dateFormat.parse(date));
//            return calendar.getTimeInMillis();
//        } catch (ParseException e) {
//            logger.error(e.getMessage(), e);
//            return 0l;
//        }
//    }
//
//    /**
//     * get Unix timestamp based on date and its pattern in integer format
//     *
//     * @param date
//     * @param pattern
//     * @return Long
//     */
//    public static int getTimeInMillisByDateWithPattern_Integer(String date, String pattern) {
//        try {
//            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
//            calendar.setTime(dateFormat.parse(date));
//            return (int)(calendar.getTimeInMillis()/1000L);
//        } catch (ParseException e) {
//            logger.error(e.getMessage(), e);
//            return 0;
//        }
//    }
//    
//    /**
//    * Convert Date with given pattern and Time Zone
//    *
//    * @param date
//    * @param pattern
//    * @param timeZone
//    * @return String
//    */
//    public static String convertDateWithTimeZone(Date date, String pattern, String timeZone) {
//        SimpleDateFormat formattedDate = new SimpleDateFormat(pattern);
//        formattedDate.setTimeZone(TimeZone.getTimeZone(timeZone));
//        return formattedDate.format(date);
//    }
//
//    /**
//     * To convert csv string to proper format
//     * to avoid formatting issues with double quotes (") and comma (,)
//     *
//     * @param input
//     * @return
//     */
//    public static String wrapWithQuotes(String input) {
//        return String.format("\"%s\"", input);
//    }
//    
//    /**
//     * Get required object from given json model
//     * 
//     * @param object
//     * @return 
//     */
//    @Loggable(value=Loggable.DEBUG)
//    public static <T> Object getObjectFromJson_WithUpperCase(String json, Class<T> klass) {
//        ObjectMapper mapper = new ObjectMapper();
//        Object object = null;
//       
//        // This is required to disable the check for unknown properties. Otherwise UnrecognizedPropertyException is thrown.
//        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
//        try {
//            object = mapper.readValue(json, klass);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        
//        return object;
//
//    }
//    
//    /**
//     * Get required object from given json model
//     * 
//     * @param object
//     * @return 
//     */
//    @Loggable(value=Loggable.DEBUG)
//    public static <T> Object getObjectFromJson(String json, Class<T> klass) {
//        ObjectMapper mapper = new ObjectMapper();
//        Object object = null;
//       
//        // This is required to disable the check for unknown properties. Otherwise UnrecognizedPropertyException is thrown.
//        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        try {
//            object = mapper.readValue(json, klass);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        
//        return object;
//
//    }
//    
//    /**
//     * Encrypt 
//     * 
//     * @param value
//     * @param key
//     * @return token
//     */
//    public static String encrypt(String value, String key) {
//        try {
//            AESEncryptorDecryptor encryptorDecryptor = new AESEncryptorDecryptor(key);
//            return encryptorDecryptor.encrypt(String.valueOf(value));
//        } catch (Exception ex) {
//            throw createBadRequest(ENCRYPTION_ERROR);
//        }
//    }
//    
//    /**
//     * Method to get sort order
//     * 
//     * @param sortField
//     * @param attibuteName
//     * @return List<Communication>
//     */
//    public static String getSortOrderForAttribute(String sortField, String attibuteName) {
//        if (DESENDING.concat(attibuteName).equals(sortField)) {
//            return DESENDING;
//        }
//        return ASCENDING;
//    }
//    
//    /**
//     * To validate request referer
//     * 
//     * @param referer
//     * @param host
//     */
//    public static void validateRequestReferer(String referer, String host) {
//        if (StringUtils.isBlank(referer)) {
//            throw ApplicationException.createBadRequest(APIErrorCodes.INVALID_REQUEST_ORIGINATOR, "Request is not from authorized origin.");
//        }
//
//        if (StringUtils.isBlank(host)) {
//            host = APIRequestHelper.getRequest().getServerName();
//        }
//        
//        logger.debug("Referer : {}, Host: {} ", referer, host);
//        if (host.equals(referer)) { //If Exact match
//            logger.debug("host and referer are exact matched.");
//            return ;
//        }
//        
//        if (extractDomain(host).equals(extractDomain(referer))) { // Partial match
//            logger.debug("host and referer are partially matched.");
//            return;
//        }
//        
//        throw ApplicationException.createBadRequest(APIErrorCodes.INVALID_REQUEST_ORIGINATOR, "Request is not from authorized origin.");
//    }
//
//    /**
//     * To extract domain 
//     * 
//     * @param host
//     * @return
//     */
//    private static String extractDomain(String host) {
//        if (host.contains(".")) {
//            return host.substring(host.indexOf("."));
//        } 
//        
//        return "";
//    }
//    
//    /**
//     * Get current year
//     * 
//     * @return
//     */
//    public static int getCurrentYear() {
//        return Calendar.getInstance().get(Calendar.YEAR);
//    }
//    
//    /**
//     * Get  Base64 encoded string
//     * 
//     * @param clientId
//     * @param clientSecret
//     * @return
//     */
//    public static String encryptToBase64(String clientId, String clientSecret) {
//        String creds = String.format("%s:%s", clientId, clientSecret);
//        try {
//            return new String(org.springframework.security.crypto.codec.Base64.encode(creds.getBytes(UTF8)));
//        } catch (UnsupportedEncodingException e) {
//            throw new IllegalStateException("Error while converting credentials basic auth string");
//        }
//    }
//    /**
//     *
//     * @param baseUrl
//     * @param endPoint
//     * @param queryParams
//     * @return
//     */
//    public static String prepareThroneUrl(String baseUrl,String endPoint, String queryParams) {
//        StringBuilder url = new StringBuilder(baseUrl);
//        url.append(endPoint.replace("v2","v1"));
//
//        if (!StringUtils.isEmpty(queryParams)) {
//            url.append(QUERY_SEPARATOR);
//            url.append(queryParams);
//        }
//        if (!url.toString().contains(BEARER_TOKEN)) {
//            logger.info("URL : {}", url);
//        }
//        return url.toString();
//    }
//
//    /**
//     * Get request payload from request
//     *
//     * @param request
//     * @return
//     * @throws IOException
//     */
//    public static Map getRequestPayLoad(HttpServletRequest request) throws IOException {
//        String requestBody = IOUtils.toString(request.getReader());
//        if (requestBody != null) {
//            return new ObjectMapper().readValue(requestBody, Map.class);
//        }
//        return null;
//    }
//
//    /**
//     * Get attribute json node
//     *
//     * @param node
//     * @param attribute
//     * @return return attribute value , else empty list
//     */
//    public static List<JsonNode> getAttribute(JsonNode node, String attribute) {
//        if (node.has(attribute)) {
//            return node.findValues(attribute);
//        }
//        return Collections.emptyList();
//    }
//
//    /**
//     * Get JSONNode value
//     *
//     * @param nodeValue
//     * @return
//     */
//    public static String getNodeValue(JsonNode nodeValue) {
//        return nodeValue != null ? nodeValue.asText() : null;
//    }
//    
//
//    /**
//     * Convert json keys to camel case
//     *
//     * @param node
//     * @return
//     * @throws IOException
//     */
//    public static Map<String, Object> convetToCamelCase(JsonNode node) throws IOException {
//        Map<String, Object> map = new HashMap<>();
//
//        StringBuffer key = new StringBuffer();
//        Object value = null;
//
//        for(Iterator<Map.Entry<String, JsonNode>> iterator = node.fields(); iterator.hasNext();) {
//            Map.Entry<String, JsonNode> entry = iterator.next();
//
//            if (entry.getValue().isObject()) {
//                value = convetToCamelCase(entry.getValue());
//
//            } else if (entry.getValue().isArray()) {
//                ArrayNode arrayNode = (ArrayNode) entry.getValue();
//                value = convertArrayNodeKeysToCamelCase(arrayNode);
//            } else if (entry.getValue().isNull()) {
//                // skip nulls
//                continue;
//            } else {
//                value = entry.getValue();
//            }
//
//            map.put(convetToCamelCase(entry.getKey()), value);
//        }
//        return map;
//    }
//
//    public static List convertArrayNodeKeysToCamelCase(ArrayNode arrayNode) throws IOException {
//        List listObject= new ArrayList();
//
//        for (JsonNode jsonNode : arrayNode) {
//            if (jsonNode.isObject()) {
//                listObject.add(convetToCamelCase(jsonNode));
//            } else {
//                listObject.add(jsonNode);
//            }
//        }
//        return listObject;
//    }
//
//
//    /**
//     * Convert json keys to snake_case
//     *
//     * @param node
//     * @return
//     * @throws IOException
//     */
//    public static Map<String, Object> convetToSnakeCase(JsonNode node) throws IOException {
//        Map<String, Object> map = new HashMap<>();
//        Object value = null;
//
//        for(Iterator<Map.Entry<String, JsonNode>> iterator = node.fields(); iterator.hasNext();) {
//            Map.Entry<String, JsonNode> entry = iterator.next();
//
//            if (entry.getValue().isObject()) {
//                value = convetToSnakeCase(entry.getValue());
//
//            } else if (entry.getValue().isArray()) {
//                ArrayNode arrayNode = (ArrayNode) entry.getValue();
//                value = convertArrayNodeKeysToSnakeCase(arrayNode);
//            } else if (entry.getValue().isNull()) {
//                // skip nulls
//                continue;
//            } else
//                value = entry.getValue();
//
//            map.put(convetToSnakeCase(entry.getKey()), value);
//        }
//        return map;
//    }
//
//    /**
//     *
//     * @param arrayNode
//     * @return
//     * @throws IOException
//     */
//    private static List convertArrayNodeKeysToSnakeCase(ArrayNode arrayNode) throws IOException {
//        List listObject= new ArrayList();
//        for (JsonNode jsonNode : arrayNode) {
//            if (jsonNode.isObject()) {
//                listObject.add(convetToSnakeCase(jsonNode));
//            } else {
//                listObject.add(jsonNode);
//            }
//        }
//        return listObject;
//    }
//
//    /**
//     * Convert to camel case
//     *
//     * @param key
//     * @return
//     * @throws IOException
//     */
//    public static String convetToCamelCase(String key) {
//        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, key);
//    }
//
//    /**
//     *
//     * @param value
//     * @return
//     * @throws IOException
//     */
//    public static String convetToSnakeCase(String value) {
//        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, value);
//    }
//
//
//    public static Optional containsPart(List operatorList, String key) {
//        return operatorList.stream().filter(s -> key.contains(s.toString())).findFirst();
//    }
//
//    /**
//     * Convert string to Md5
//     *
//     * @param value to format
//     * @return string md5
//     */
//    public static String getMD5(String value) {
//
//        if (value.equals(EMPTY_STRING)){
//            return value;
//        }
//
//        MessageDigest algorithm = null;
//
//        try {
//            algorithm = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//
//        byte[] defaultBytes = value.getBytes();
//        Objects.requireNonNull(algorithm).reset();
//        algorithm.update(defaultBytes);
//        byte[] messageDigest = algorithm.digest();
//        StringBuilder hexString = new StringBuilder();
//
//        for (byte b : messageDigest) {
//            String hex = Integer.toHexString(0xff & b);
//            if (hex.length() == 1) {
//                hexString.append('0');
//            }
//            hexString.append(hex);
//        }
//        return hexString.toString();
//    }
//    
//    /**
//     * Method will help to determine state of AR sku 
//     * @param sku
//     * @return
//     */
//    public static String getArSkuState(String[] arSkuState) {
//        StringBuilder allChoice = new StringBuilder();
//        if (arSkuState != null && arSkuState.length > 0) {
//            for (String skuState : arSkuState) {
//                allChoice = allChoice.append(skuState.toUpperCase());
//            }
//            String arVal = ArSkuStateEnum.valueOf(allChoice.toString()).getArValue();
//            if (arVal != null) {
//                return arVal;
//            }
//        }
//        return null;
//    }
//
//
//    /**
//     * Get current date in 'MMMM dd, yyyy' format
//     * 
//     * @return
//     */
//    public static String getCurrentDateWithYearName() {
//        SimpleDateFormat simpleformat = new SimpleDateFormat(ApplicationConstants.MONTH_DATE_YEAR_FORMAT);
//        String date = simpleformat.format(new Date());
//        return date;
//    }
//
//
//
//    /**
//     *
//     * @param date
//     * @return
//     */
//    public static Long convertSendDate(String date) {
//        if (!org.springframework.util.StringUtils.isEmpty(date)) {
//            try {
//                return Long.parseLong(date);
//            } catch (Exception e) {
//                logger.error("Error while parsing date {} to long", date);
//                logger.error(e.getMessage(), e);
//            }
//        }
//        return 0L;
//    }
//    
}