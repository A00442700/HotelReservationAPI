http://localhost:8080/getHotelList
Api to get the list of Hotels with the details.
As a response will get the list of Hotels.

API:
http://localhost:8080/reservationConfirmation
To post the details body should contain below details.
Example

{
    "hotel_name": "Wedgewood",
    "checkin": "June 25,2021",
    "checkout": "july1 2021",
    "guest_list": [
        {
            "firstName": "Nikitha",
            "lastName": "M"
        },
        {
            "firstName": "Sai",
            "lastName": "S" 
        },
        {
            "firstName": "Aarvika",
            "lastName": "S"
        }

    ]

}

as a response will the string as reservation confirmed.