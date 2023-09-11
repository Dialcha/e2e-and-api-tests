describe('Existing User Registration Test in Demoblaze', () => {
    it('should make a POST request to signup and return that the user already exists', () => {
      const url = 'https://api.demoblaze.com/signup';
  
      const requestData = {
        username: 'admin',
        password: 'test'
      };
  
      const headers = {
        'authority': 'api.demoblaze.com',
        'accept': '*/*',
        'content-type': 'application/json',
      };
  
      cy.request({
        method: 'POST',
        url: url,
        headers: headers,
        body: requestData,
        failOnStatusCode: false
      }).then((response) => {
        expect(response.status).to.equal(200);
        expect(response.body.errorMessage).to.equal('This user already exist.');
      });
    });
  });


  describe('Successful User Registration Test in DemoBlaze', () => {
    it('should successfully make a POST request to the registration service', () => {
      const url = 'https://api.demoblaze.com/signup';
  
      const uniqueUsername = `user_${Date.now()}`;
  
      const requestData = {
        username: uniqueUsername,
        password: 'test'
      };
  
      const headers = {
        'authority': 'api.demoblaze.com',
        'accept': '*/*',
        'content-type': 'application/json',
      };
  
      cy.request({
        method: 'POST',
        url: url,
        headers: headers,
        body: requestData,
        failOnStatusCode: false
      }).then((response) => {
        expect(response.status).to.equal(200);
        expect(response.body.errorMessage).to.be.undefined;
        expect(response.body).to.equal('')
      });
    });
  });