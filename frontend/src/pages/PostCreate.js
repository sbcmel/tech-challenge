import React, { useState } from "react";
import axios from "../axios-javabackend";
import DropdownList from '../components/DropdownList';
import Table from "../components/Table";

const PostCreate = () => {
  const [tableData, setTableData] = useState([])

  const onSubmit = async (event) => {
    event.preventDefault();
    console.log(event.target.elements.Airport.value);
    console.log(event.target.elements.radioOption.value);

    const airportString = event.target.elements.Airport.value;
    const sidString = event.target.elements.radioOption.value;
    let uri = "";
    if (sidString === "sid" ) {
      uri = "/sid2waypoints/"+airportString;
    } else if (sidString === "Star") {
      uri = "/stars2waypoints/"+airportString;
    }
  
    try {
      const response = await axios.get(uri);
      setTableData(response.data);
    } catch(err) {
      
    }
    
  };

  return (
    <div>
      <form onSubmit={onSubmit}>
        <div className="form-group">
          <div className="container mt-2">
            <DropdownList/>
          </div>
        </div>
        <div className="container mt-2">
          <label>
            <input type="radio" name="radioOption" value="sid" checked/>SID
          </label>
          <br/>
          <label>
            <input type="radio" name="radioOption" value="Star" />STAR
          </label>
          <br/><br/>
          <button className="btn btn-primary">Submit</button>
          </div>
      </form>
      <br/><br/>
      <Table tableData={tableData}/>
    </div>
  );
};

export default PostCreate;
