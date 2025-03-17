import React from 'react';

const Collections = (props) => {
  const { title, image1, image2, image3, image4, image5, image6 } = props.gentsFashion;
  
  return (
    <div className='collectionSeaction'>
      <h2>{title}</h2>
      <div className="menImages">
        <div>
          <img src={image1} alt={title} />
          <p className="style">T-Shirt 1 - ₹25</p>
        </div>
        <div>
          <img src={image2} alt={title} />
          <p className="style">T-Shirt 2 - ₹30</p>
        </div>
        <div>
          <img src={image3} alt={title} />
          <p className="style">T-Shirt 3 - ₹28</p>
        </div>
        <div>
          <img src={image4} alt={title} />
          <p className="style">T-Shirt 4 - ₹35</p>
        </div>
        <div>
          <img src={image5} alt={title} />
          <p className="style">T-Shirt 5 - ₹22</p>
        </div>
        <div>
          <img src={image6} alt={title} />
          <p className="style">T-Shirt 6 - ₹27</p>
        </div>
      </div>
    </div>
  );
};

export default Collections;
