import axios from 'axios';
import React, { Component } from 'react'
import ShowFavFood from './ShowFavFood'
import './favfood.css';


export default class favfood extends Component {

  // For storing favourite foods response coming from REST API
  state = {
    userFav: [

    ]

  }

  componentDidMount() {

    //Getting user's emailId
    const emailId = localStorage.getItem("emailId");
    //Getting JWT Token
    const token = localStorage.getItem("token");
    //API url endpoint of REST API
    const api_url = `http://localhost:9009/fav/users/${emailId}`;
     
    //Sending get request to get all favourite foods of the user
    axios.get(api_url, {
      headers: {
        'Access-Control-Allow-Origin': '*',
         Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json'
      }
    })
      .then(res => {
 
        //Storing response into state
        this.setState({ userFav: res.data.foods })
      })
      .catch(e => {
      })

  }

  render() {

    return (
      <div className="favfood-body">
        <div className="favfood-shade">        
        <p className="h1 text-left p-5 text-white-50 font-weight-bold">Favourite Foods</p>
        <div className="pt-2">
         { this.state.userFav !=null ? (
            this.state.userFav.map(item => (
              <ShowFavFood foodItem={item} />
            ))
         ) : null
          }
          </div>
      </div>
      </div>
    )
  }
}

