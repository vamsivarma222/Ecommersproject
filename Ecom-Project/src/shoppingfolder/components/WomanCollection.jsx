import React from 'react';

const WomanCollection = (props) => {
    const { title, image1, image2, image3, image4, image5, image6 } = props.ladiesFashion;
    
    return (
        <div className='collectionSeaction'>
            <h2>{title}</h2>
            <div className="bannerBox">
                <img src="assets/LadiesBanner.gif" alt="Ladies Fashion Banner" />
            </div>
            <div className="womenImages">
                <div>
                    <img src={image1} alt={title} />
                    <p className="style">Dress 1 - ₹999</p>
                </div>
                <div>
                    <img src={image2} alt={title} />
                    <p className="style">Dress 2 - ₹1299</p>
                </div>
                <div>
                    <img src={image3} alt={title} />
                    <p className="style">Dress 3 - ₹1499</p>
                </div>
                <div>
                    <img src={image4} alt={title} />
                    <p className="style">Dress 4 - ₹899</p>
                </div>
                <div>
                    <img src={image5} alt={title} />
                    <p className="style">Dress 5 - ₹1199</p>
                </div>
                <div>
                    <img src={image6} alt={title} />
                    <p className="style">Dress 6 - ₹1599</p>
                </div>
            </div>
        </div>
    );
};

export default WomanCollection;
