package xdptdr.ulhiunteco.at;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "TYPOLOGY_AT")
public class TypologyAT {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Type(type = "big_decimal")
	@Column(name = "BIG_DECIMAL_AT")
	private BigDecimal aBigDecimal;

	@Type(type = "big_integer")
	@Column(name = "BIG_INTEGER_AT")
	private BigInteger aBigInteger;

	@Type(type = "binary")
	@Column(name = "BINARY_AT")
	private byte[] aBinary;

	@Type(type = "blob")
	@Column(name = "BLOB_AT")
	private Blob aBlob;

	@Type(type = "boolean")
	@Column(name = "BOOLEAN_AT")
	private boolean aBoolean;

	@Type(type = "byte")
	@Column(name = "BYTE_AT")
	private byte aByte;

	@Type(type = "calendar")
	@Column(name = "CALENDAR_AT")
	private Calendar aCalendar;

	@Type(type = "calendar_date")
	@Column(name = "CALENDAR_DATE_AT")
	private Calendar aCalendarDate;

	@Type(type = "characters")
	@Column(name = "CHARACTERS_AT")
	char[] aCharacters;

	@Type(type = "character")
	@Column(name = "CHARACTER_AT")
	Character aCharacter;

	@Type(type = "wrapper-characters")
	@Column(name = "WRAPPER_CHARACTER_AT")
	Character[] aWrapperCharacter;

	@Type(type = "class")
	@Column(name = "CLASS_AT")
	Class<?> aClass;

	@Type(type = "clob")
	@Column(name = "CLOB_AT")
	Clob aClob;

	@Type(type = "currency")
	@Column(name = "CURRENCY_AT")
	Currency aCurrency;

	@Type(type = "date")
	@Column(name = "DATE_AT")
	Date aDate;

	@Type(type = "double")
	@Column(name = "DOUBLE_AT")
	Double aDouble;

	@Type(type = "float")
	@Column(name = "FLOAT_AT")
	Float aFloat;

	@Type(type = "image")
	@Column(name = "IMAGE_AT")
	byte[] aImage;

	@Type(type = "integer")
	@Column(name = "INTEGER_AT")
	Integer aInteger;

	@Type(type = "locale")
	@Column(name = "LOCALE_AT")
	Locale aLocale;

	@Type(type = "long")
	@Column(name = "LONG_AT")
	Long aLong;

	@Type(type = "materialized_blob")
	@Column(name = "MATERIALIZED_BLOB_AT")
	byte[] aMaterializedBlob;

	@Type(type = "materialized_clob")
	@Column(name = "MATERIALIZED_CLOB_AT")
	String aMaterializedClob;

	/*
	 * @Type(type = "materialized_nclob")
	 * 
	 * @Column(name = "MATERIALIZED_NCLOB_AT") String aMaterializedNClob;
	 */

	/*
	 * @Type(type = "nclob")
	 * 
	 * @Column(name = "NCLOB_AT") NClob aNClob;
	 */

	/*
	 * @Type(type = "ntext")
	 * 
	 * @Column(name = "NTEXT_AT") String aNText;
	 */
	@Type(type = "numeric_boolean")
	@Column(name = "NUMERIC_BOOLEAN_AT")
	Boolean aNumericBoolean;

	@Type(type = "serializable")
	@Column(name = "SERIALIZABLE_AT")
	Serializable aSerialieable;

	@Type(type = "short")
	@Column(name = "SHORT_AT")
	Short aShort;

	@Type(type = "string")
	@Column(name = "STRING_AT")
	String aString;

	@Type(type = "text")
	@Column(name = "TEXT_AT")
	String aText;

	@Type(type = "time")
	@Column(name = "TIME_AT")
	Date aTime;

	@Type(type = "timestamp")
	@Column(name = "TIMESTAMP_AT")
	Date aTimestamp;

	@Type(type = "timezone")
	@Column(name = "TIMEZONE_AT")
	TimeZone aTimezone;

	@Type(type = "true_false")
	@Column(name = "TRUE_FALSE_AT")
	Boolean aTrueFalse;

	@Type(type = "url")
	@Column(name = "URL_AT")
	URL aURL;

	@Type(type = "uuid-binary")
	@Column(name = "UUID_BINARY_AT")
	UUID aUUIDBinary;

	@Type(type = "uuid-char")
	@Column(name = "UUID_CHAR_AT")
	UUID aUUIDChar;

	@Type(type = "wrapper-binary")
	@Column(name = "WRAPPER_BINARY_AT")
	Byte[] aWrapperBinary;

	@Type(type = "yes_no")
	@Column(name = "YES_NO_AT")
	Boolean aYesNo;

	public TypologyAT() {
	}

	public TypologyAT(BigDecimal aBigDecimal, BigInteger aBigInteger, byte[] aBinary, Blob aBlob, boolean aBoolean,
			byte aByte, Calendar aCalendar, Calendar aCalendarDate, char[] aCharacters, Character aCharacter,
			Character[] aWrapperCharacter, Class<?> aClass, Clob aClob, Currency aCurrency, Date aDate, Double aDouble,
			Float aFloat, byte[] aImage, Integer aInteger, Locale aLocale, Long aLong, byte[] aMaterializedBlob,
			String aMaterializedClob, String aMaterializedNClob, NClob aNClob, String aNText, Boolean aNumericBoolean,
			Serializable aSerialieable, Short aShort, String aString, String aText, Date aTime, Date aTimestamp,
			TimeZone aTimezone, Boolean aTrueFalse, URL aURL, UUID aUUIDBinary, UUID aUUIDChar, Byte[] aWrapperBinary,
			Boolean aYesNo) {
		this.aBigDecimal = aBigDecimal;
		this.aBigInteger = aBigInteger;
		this.aBinary = aBinary;
		this.aBlob = aBlob;
		this.aBoolean = aBoolean;
		this.aByte = aByte;
		this.aCalendar = aCalendar;
		this.aCalendarDate = aCalendarDate;
		this.aCharacters = aCharacters;
		this.aCharacter = aCharacter;
		this.aWrapperCharacter = aWrapperCharacter;
		this.aClass = aClass;
		this.aClob = aClob;
		this.aCurrency = aCurrency;
		this.aDate = aDate;
		this.aDouble = aDouble;
		this.aFloat = aFloat;
		this.aImage = aImage;
		this.aInteger = aInteger;
		this.aLocale = aLocale;
		this.aLong = aLong;
		this.aMaterializedBlob = aMaterializedBlob;
		this.aMaterializedClob = aMaterializedClob;
		// this.aMaterializedNClob = aMaterializedNClob;
		// this.aNClob = aNClob;
		// this.aNText = aNText;
		this.aNumericBoolean = aNumericBoolean;
		this.aSerialieable = aSerialieable;
		this.aShort = aShort;
		this.aString = aString;
		this.aText = aText;
		this.aTime = aTime;
		this.aTimestamp = aTimestamp;
		this.aTimezone = aTimezone;
		this.aTrueFalse = aTrueFalse;
		this.aURL = aURL;
		this.aUUIDBinary = aUUIDBinary;
		this.aUUIDChar = aUUIDChar;
		this.aWrapperBinary = aWrapperBinary;
		this.aYesNo = aYesNo;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getaBigDecimal() {
		return aBigDecimal;
	}

	public void setaBigDecimal(BigDecimal aBigDecimal) {
		this.aBigDecimal = aBigDecimal;
	}

	public BigInteger getaBigInteger() {
		return aBigInteger;
	}

	public void setaBigInteger(BigInteger aBigInteger) {
		this.aBigInteger = aBigInteger;
	}

	public byte[] getaBinary() {
		return aBinary;
	}

	public void setaBinary(byte[] aBinary) {
		this.aBinary = aBinary;
	}

	public Blob getaBlob() {
		return aBlob;
	}

	public void setaBlob(Blob aBlob) {
		this.aBlob = aBlob;
	}

	public boolean isaBoolean() {
		return aBoolean;
	}

	public void setaBoolean(boolean aBoolean) {
		this.aBoolean = aBoolean;
	}

	public byte isaByte() {
		return aByte;
	}

	public void setaByte(byte aByte) {
		this.aByte = aByte;
	}

	public Object getaCalendar() {
		return aCalendar;
	}

	public void setaCalendar(Calendar aCalendar) {
		this.aCalendar = aCalendar;
	}

	public byte getaByte() {
		return aByte;
	}

	public Calendar getaCalendarDate() {
		return aCalendarDate;
	}

	public void setaCalendarDate(Calendar aCalendarDate) {
		this.aCalendarDate = aCalendarDate;
	}

	public char[] getaCharacters() {
		return aCharacters;
	}

	public void setaCharacters(char[] aCharacters) {
		this.aCharacters = aCharacters;
	}

	public Character getaCharacter() {
		return aCharacter;
	}

	public void setaCharacter(Character aCharacter) {
		this.aCharacter = aCharacter;
	}

	public Character[] getaWrapperCharacter() {
		return aWrapperCharacter;
	}

	public void setaWrapperCharacter(Character[] aWrapperCharacter) {
		this.aWrapperCharacter = aWrapperCharacter;
	}

	public Class<?> getaClass() {
		return aClass;
	}

	public void setaClass(Class<?> aClass) {
		this.aClass = aClass;
	}

	public Clob getaClob() {
		return aClob;
	}

	public void setaClob(Clob aClob) {
		this.aClob = aClob;
	}

	public Currency getaCurrency() {
		return aCurrency;
	}

	public void setaCurrency(Currency aCurrency) {
		this.aCurrency = aCurrency;
	}

	public Date getaDate() {
		return aDate;
	}

	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}

	public Double getaDouble() {
		return aDouble;
	}

	public void setaDouble(Double aDouble) {
		this.aDouble = aDouble;
	}

	public Float getaFloat() {
		return aFloat;
	}

	public void setaFloat(Float aFloat) {
		this.aFloat = aFloat;
	}

	public byte[] getaImage() {
		return aImage;
	}

	public void setaImage(byte[] aImage) {
		this.aImage = aImage;
	}

	public Integer getaInteger() {
		return aInteger;
	}

	public void setaInteger(Integer aInteger) {
		this.aInteger = aInteger;
	}

	public Locale getaLocale() {
		return aLocale;
	}

	public void setaLocale(Locale aLocale) {
		this.aLocale = aLocale;
	}

	public Long getaLong() {
		return aLong;
	}

	public void setaLong(Long aLong) {
		this.aLong = aLong;
	}

	public byte[] getaMaterializedBlob() {
		return aMaterializedBlob;
	}

	public void setaMaterializedBlob(byte[] aMaterializedBlob) {
		this.aMaterializedBlob = aMaterializedBlob;
	}

	public String getaMaterializedClob() {
		return aMaterializedClob;
	}

	public void setaMaterializedClob(String aMaterializedClob) {
		this.aMaterializedClob = aMaterializedClob;
	}

	/*
	 * public String getaMaterializedNClob() { return aMaterializedNClob; }
	 * 
	 * public void setaMaterializedNClob(String aMaterializedNClob) {
	 * this.aMaterializedNClob = aMaterializedNClob; }
	 */
	/*
	 * public NClob getaNClob() { return aNClob; }
	 * 
	 * public void setaNClob(NClob aNClob) { this.aNClob = aNClob; }
	 */

	/*
	 * public String getaNText() { return aNText; }
	 * 
	 * public void setaNText(String aNText) { this.aNText = aNText; }
	 */

	public Boolean getaNumericBoolean() {
		return aNumericBoolean;
	}

	public void setaNumericBoolean(Boolean aNumericBoolean) {
		this.aNumericBoolean = aNumericBoolean;
	}

	public Serializable getaSerialieable() {
		return aSerialieable;
	}

	public void setaSerialieable(Serializable aSerialieable) {
		this.aSerialieable = aSerialieable;
	}

	public Short getaShort() {
		return aShort;
	}

	public void setaShort(Short aShort) {
		this.aShort = aShort;
	}

	public String getaString() {
		return aString;
	}

	public void setaString(String aString) {
		this.aString = aString;
	}

	public String getaText() {
		return aText;
	}

	public void setaText(String aText) {
		this.aText = aText;
	}

	public Date getaTime() {
		return aTime;
	}

	public void setaTime(Date aTime) {
		this.aTime = aTime;
	}

	public Date getaTimestamp() {
		return aTimestamp;
	}

	public void setaTimestamp(Date aTimestamp) {
		this.aTimestamp = aTimestamp;
	}

	public TimeZone getaTimezone() {
		return aTimezone;
	}

	public void setaTimezone(TimeZone aTimezone) {
		this.aTimezone = aTimezone;
	}

	public Boolean getaTrueFalse() {
		return aTrueFalse;
	}

	public void setaTrueFalse(Boolean aTrueFalse) {
		this.aTrueFalse = aTrueFalse;
	}

	public URL getaURL() {
		return aURL;
	}

	public void setaURL(URL aURL) {
		this.aURL = aURL;
	}

	public UUID getaUUIDBinary() {
		return aUUIDBinary;
	}

	public void setaUUIDBinary(UUID aUUIDBinary) {
		this.aUUIDBinary = aUUIDBinary;
	}

	public UUID getaUUIDChar() {
		return aUUIDChar;
	}

	public void setaUUIDChar(UUID aUUIDChar) {
		this.aUUIDChar = aUUIDChar;
	}

	public Byte[] getaWrapperBinary() {
		return aWrapperBinary;
	}

	public void setaWrapperBinary(Byte[] aWrapperBinary) {
		this.aWrapperBinary = aWrapperBinary;
	}

	public Boolean getaYesNo() {
		return aYesNo;
	}

	public void setaYesNo(Boolean aYesNo) {
		this.aYesNo = aYesNo;
	}

}
