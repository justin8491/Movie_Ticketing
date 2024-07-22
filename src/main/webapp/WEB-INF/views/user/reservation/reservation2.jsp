<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 헤더쪽에 path있음 -->
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html >

<head>
<meta charset="UTF-8">
  <%@ include file = "/resources/include/header.jsp"%>



<title>예매사이트</title>

<style>

body{
    font-family: 'Lato', sans-serif;
    background-color: #242333;
    color: #fff;
    box-sizing: border-box;
}

#container{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 800px;

}

.movieContainer{
    margin: 20px 0px;
}

.showcase{
    background-color: #777;
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    display: flex;
    justify-content: center;
    margin: 16px 0;
    padding: 5px 10px;
}

.movieContainer select{
    margin: 10px;
    padding: 5px 15px 5px 15px;
    border-radius: 7px;
    appearance: none;
    border: 0;
}

.movieContainer select option{

   text-align: left;
}

li{
    display: flex;
    justify-content: center;
    align-items: center;
    margin-left: 10px;
}

.small{
    color: #777;
    margin-left: 2px;
}

.showcase .seat:hover{
    cursor: default;
    scale: 1;
}

.showcase .selectedSeat:hover{
    cursor: default;
    scale: 1;
}

.screen{
   background-color: #fff;
   margin: 25px;
   padding: 5px;
   width: 140px;
   height: 80px;
   transform: rotateX(-45deg);
   box-shadow: 0 3px 10px rgb(255 255 255 / 70%);
}

.seat{
    background-color: #444451;
    width: 15px;
    height: 12px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    cursor: pointer;
}

.availableSeat{
    background-color: #444451;
    width: 15px;
    height: 12px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    cursor: default;
}

.selectedSeatIcon{
    background-color: #6feaf6;
    width: 15px;
    height: 12px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    cursor: default;
}

.seat:hover{
    scale: 1.2;
}

.selectedSeat:hover{
    scale: 1.2;
}

.seat:nth-of-type(2){
    margin-right: 18px;
}

.seat:nth-of-type(7){
    margin-left: 18px;
}

.occupiedSeat:nth-of-type(2){
    margin-right: 18px;
}
.occupiedSeat:nth-of-type(7){
    margin-left: 18px;
}

.selectedSeat{
    background-color: #6feaf6;
    width: 15px;
    height: 12px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    cursor: pointer;
}

.occupiedSeat{
    background-color: #fff;
    width: 15px;
    height: 12px;
    margin: 3px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}

.row{
    display: flex;
}

.text{
    margin-top: 30px;
    padding: 20px;
}

#count{
    color: #6feaf6;
}

#costs{
    color: #6feaf6;
}

</style>


</head>
<body>

  <div id="container">
        <div class="movieContainer">
            <label for="movie">
                Pick a Movie :
            </label>
            <select name="pickMovie" id="movie">
                <option class="price" value="10">Avengers:Endgame ($10)</option>
                <option class="price" value="12">Joker ($12)</option>
                <option class="price" value="8">Toy Story 4 ($8)</option>
                <option class="price" value="9">The Lion King ($9)</option>
            </select>
        </div>
        <ul class="showcase">
            <li>
                <div class="availableSeat"></div>
                <small class="small">Available Seat</small>
            </li>
            <li>
                <div class="selectedSeatIcon"></div>
                <small class="small">Selected Seat</small>
            </li>
            <li>
                <div class="occupiedSeat"></div>
                <small class="small">Occupied Seat</small>
            </li>
        </ul>

        <div class="seatContainer">
            <div class="screen"></div>
            <div class="row">
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
            </div>

            <div class="row">
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="occupiedSeat"></span>
                <span class="occupiedSeat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
            </div>

            <div class="row">
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="occupiedSeat"></span>
                <span class="seat"></span>
            </div>

            <div class="row">
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="occupiedSeat"></span>
                <span class="occupiedSeat"></span>
            </div>

            <div class="row">
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
            </div>

            <div class="row">
                <span class="seat"></span>
                <span class="occupiedSeat"></span>
                <span class="occupiedSeat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="seat"></span>
                <span class="occupiedSeat"></span>
                <span class="seat"></span>
            </div>

        </div>

        <p class="text">You have selected <span id="count">0</span> seats for a price of $ <span id="costs">0</span></p>




    </div>

</body>
</html>