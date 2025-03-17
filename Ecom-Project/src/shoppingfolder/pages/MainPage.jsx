
import React,{useState} from 'react'
import Header from '../components/header'
import Banner from '../components/Banner'
import Footer from '../components/Footer'
import Collections from '../components/collections'
import { Gents } from '../data'
import { Ladies } from '../data'
import WomanCollection from '../components/WomanCollection'

const MainPage = () => {

  const[gentsFashion, setGentsFashion] = useState(Gents)
  const[ladiesFashion, setLadiesFashion] = useState(Ladies)
  console.log(Gents)
  console.log(Ladies)
  return (
    <div>
        <Header/>
        <Banner/>
        <Collections gentsFashion={gentsFashion}/>
        <WomanCollection ladiesFashion ={ladiesFashion}/>
        <Footer/>
    </div>
  )
}

export default MainPage