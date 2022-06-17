import React, {useState, useEffect} from 'react';

import AirportObject from '../AirportObject/AirportObject';

import classes from './AirportList.module.css';

import axios from '../../axios-javabackend';


const AirportList = (props) => {
    
    const [airportList, setAirportList] = useState([]);
    const [httpError, setHttpError] = useState(false);


    useEffect( () => {
        console.log('airportList useEffect called!')

        axios.get('/getAirports')
        .then(res =>{
            
            console.log(res.data);

            setAirportList(res.data);
        })
        .catch( err => {
            console.log(err);
            setHttpError(true);
        });


    }, []);


    const OnClickHandler = (icao) => {
        console.log("I GOT PRESSED "+ icao) 
    }
    
    
    let airportJsx =  
    (<div className={classes.AirportList}>
        {
            airportList.map((airport) => (
            <AirportObject
                onClick = { () => { OnClickHandler(airport.icao) }}
                key={airport.icao}
                icao={airport.icao}
                name={airport.name}
            />

        ))}
    </div> );  

    if(httpError) airportJsx = <h1>Http error!</h1>
    
    return (
        <div>
            {airportJsx}
        </div>
    );
}

export default AirportList;