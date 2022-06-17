import React from 'react'
import axios from '../axios-javabackend';

export const Dropdown = (props) => (
  <div className="form-group">
    <select
      className="form-control"
      name="Airport"
      onChange={props.onChange}
    >
      <option defaultValue>Select {props.name}</option>
      {props.options.map((item, index) => (
        <option key={index} value={item.icao}>
          {item.name}
        </option>
      ))}
    </select>
  </div>
)

export default class DropdownList extends React.Component {
  constructor() {
    super()
    this.state = {
      list: [],
      chosenValue: '',
    }
  }

  componentDidMount() {
    axios.get('/getAirports')
      .then((response) => response.data)
      .then((item) => this.setState({ list: item }))
  }

  onDropdownChange = (e) => {
    this.setState({ chosenValue: e.target.value })
  }

  render() {
    return (
      <div>
        <Dropdown
          name='Airport'
          options={this.state.list}
          onDropdownChange={this.onDropdownChange}
        />
      </div>
    )
  }
}