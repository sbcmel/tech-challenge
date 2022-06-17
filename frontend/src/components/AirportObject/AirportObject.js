import React from 'react';

import classes from './AirportObject.module.css'

/*
"uid": "WSSS",
        "name": "WSSS",
        "icao": "WSSS",
        "lat": 1.3591666666666666,
        "alt": 22.0,
        "iata": null,
        "lng": 103.99111111111111
*/

function AirportObject(props) {
    return (
        <div className={classes.airportobject} onClick={props.onClick}>
            <h2>Airport Details</h2>
            <p>NAME: {props.name}</p>
            <p>ICAO: {props.icao}</p>
        </div>
    );
}

export default AirportObject;