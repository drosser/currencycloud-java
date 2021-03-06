package com.currencycloud.client.model;

import com.currencycloud.client.Utils;
import com.currencycloud.client.dirty.DirtyWatcherDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.text.SimpleDateFormat;
import java.util.*;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(converter = DirtyWatcherDeserializer.Payer.class)
public class Payer implements Entity {

    private String id;
    private String legalEntityType;
    private String companyName;
    private String firstName;
    private String lastName;
    private List<String> address = new ArrayList<>();
    private String city;
    private String stateOrProvince;
    private String country;
    private String identificationType;
    private String identificationValue;
    private String postcode;
    private Date dateOfBirth;
    private Date createdAt;
    private Date updatedAt;

    protected Payer() { }

    private Payer(String entityType,
                  String companyName,
                  String firstName,
                  String lastName,
                  List<String> address,
                  String city,
                  String country,
                  String postcode,
                  String stateOrProvince,
                  Date dateOfBirth,
                  String identificationType,
                  String identificationValue
    ) {
        this.legalEntityType = entityType;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.address = address;
        this.postcode = postcode;
        this.stateOrProvince = stateOrProvince;
        this.dateOfBirth = dateOfBirth;
        this.identificationType = identificationType;
        this.identificationValue = identificationValue;
    }

    public static Payer create() {
        return new Payer();
    }

    public static Payer create(String entityType,
                               String companyName,
                               String firstName,
                               String lastName,
                               List<String> address,
                               String city,
                               String country,
                               String postcode,
                               String stateOrProvince,
                               Date dateOfBirth,
                               String identificationType,
                               String identificationValue
    ) {
        return new Payer(entityType,
                         companyName,
                         firstName,
                         lastName,
                         address,
                         city,
                         country,
                         postcode,
                         stateOrProvince,
                         dateOfBirth,
                         identificationType,
                         identificationValue
        );
    }

    /**
     * Create payer with minimum set of required attributes
     * @param entityType
     * @param companyName
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param country
     * @param dateOfBirth
     */
    public static Payer create(String entityType,
                               String companyName,
                               String firstName,
                               String lastName,
                               List<String> address,
                               String city,
                               String country,
                               Date dateOfBirth
    ) {
        return new Payer(entityType,
                companyName,
                firstName,
                lastName,
                address,
                city,
                country,
                null,
                null,
                dateOfBirth,
                null,
                null
        );
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegalEntityType() {
        return legalEntityType;
    }

    public void setLegalEntityType(String legalEntityType) {
        this.legalEntityType = legalEntityType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationValue() {
        return identificationValue;
    }

    public void setIdentificationValue(String identificationValue) {
        this.identificationValue = identificationValue;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        final ObjectMapper objectMapper = new ObjectMapper()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .setDateFormat(new SimpleDateFormat(Utils.dateFormat));

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("legalEntityType", legalEntityType);
        map.put("companyName", companyName);
        map.put("firstName", firstName);
        map.put("lastName", lastName);
        map.put("address", address);
        map.put("city", city);
        map.put("stateOrProvince", stateOrProvince);
        map.put("country", country);
        map.put("identificationType", identificationType);
        map.put("identificationValue", identificationValue);
        map.put("postcode", postcode);
        map.put("dateOfBirth", dateOfBirth);
        map.put("createdAt", createdAt);
        map.put("updatedAt", updatedAt);

        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return String.format("{\"error\": \"%s\"}", e.getMessage());
        }
    }
}
