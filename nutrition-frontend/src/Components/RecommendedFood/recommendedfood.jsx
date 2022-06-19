import axios from 'axios';
import React, { Component } from 'react'
import './recommendedfood.css';
import ShowrecommendedFood from "./ShowrecommendedFood.jsx"

export default class recommendedfood extends Component {

  // For storing recommendedourite foods response coming from REST API
  state = {
    userrecommended: [

    ]

  }

  componentDidMount() {

    //Getting user's emailId
    const emailId = localStorage.getItem("emailId");
    //Getting JWT Token
    const token = localStorage.getItem("token");
    //API url endpoint of REST API
    const api_url = `http://localhost:9010/recommended/users/${emailId}`;
     
    //Sending get request to get all favourite foods of the user
    axios.get(api_url, {
      headers: {
        'Access-Control-Allow-Origin': '*', Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json'
      }
    })
      .then(res => {
 
        //Storing response into state
        this.setState({ userrecommended: res.data.foods })
      
      })
      .catch(e => {
        console.log(e);
      })
     
  }

  render() {

    return (
      <div className="favfood-body">
        <div className="favfood-shade">        
        <p className="h1 text-left p-5 text-white-50 font-weight-bold">Recommended Foods</p>
        <div className="pt-2">
         { this.state.userrecommended !=null ? (
            this.state.userrecommended.map(item => (
              <ShowrecommendedFood foodItem={item} />
            ))
         ) : null
          }
          </div>
      </div>
      </div>
    )
  }
}

