package com.agical.golddigger.model.fieldcreator;

import com.agical.golddigger.model.Square;

public class StringFieldCreator extends FieldCreator {
    
	private static final String MAP_INFO_MARKER = "!\n";
    private static final int WALLS = 2;
    private final String result;
    private Square[][] squares;

    public StringFieldCreator(String result) {
        this.result = result;
    }

    public Square[][] createField() {
        return getSquares();
    }
    
    public int getNumberOfSides(){
    	if(result.contains(MAP_INFO_MARKER)){
    	String mapInfo = (result.split(MAP_INFO_MARKER))[1].toString();
	    	if(mapInfo.contains("6")){
	    		return 6;
    		}
	    	else{
	    		return 4;
	    	}	    	
    	}
    	else{
    		return 4;
    	}
    }

    private Square[][] getSquares() {
        if(squares!=null) return squares;
        String[] rows = result.split("\n");
        
        //This if statement when integrated with the movement cost 
        //code will need to be changed depending on how we will define the
        //map info and the map String's placement in the .field file.
        //Right now  this if statement is used to just get the default
        //MapString ( the one without the movement costs).
        if(result.contains(MAP_INFO_MARKER)){
        	rows = (result.split(MAP_INFO_MARKER)) [2].split("\n");
        }
        
        
        squares = new Square[rows.length][];
        for (int rowCount = 0; rowCount<rows.length; rowCount++) {
            String charRow = rows[rowCount];
            Square[] squareRow = new Square[charRow.length()];
            squares[rowCount] = squareRow;
            for (int i = 0; i < charRow.length(); i++) {
                char squareChar = charRow.charAt(i);
                squareRow[i] = Square.createFromChar(squareChar); 
            }
        }
        return squares;
    }
    
    public int getMaxLatitude() {
        return getSquares().length-WALLS;
    }
    
    public int getMaxLongitude() {
        return getSquares()[0].length-WALLS;
    }
    
}
