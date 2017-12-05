/**
 * Caculate the values
 */
function caculateValues(val1, val2) {
	var value1 = convertToNumber(val1);
	var value2 = convertToNumber(val2);
	
	return Math.floor(value1*value2);
}

/**
 * Utility method to check the value of the attribute
 */
function convertToNumber(attribute){
	if (isNaN(attribute)) {
		attribute = 0;
	}
	
	return Number(attribute);
}