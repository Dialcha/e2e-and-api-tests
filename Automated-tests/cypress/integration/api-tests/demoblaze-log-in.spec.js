describe('Test of login with incorrect password', () => {
    it('Should make a POST request to the registration service and return an wrong password message', () => {
      const url = 'https://api.demoblaze.com/login';
  
      const requestData = {
        username: 'admin',
        password: 'testfail'
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
        expect(response.body.errorMessage).to.equal('Wrong password.');
      });
    });
  });


  describe('Test of login with a valid password', () => {
    it('Should make a successful POST request to the login service and return a token', () => {
      const url = 'https://api.demoblaze.com/login';
  
      const requestData = {
        username: 'admin',
        password: 'YWRtaW4='
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
        console.log('BODY: ', response )
        expect(response.status).to.equal(200);
        expect(response.body.errorMessage).to.be.undefined;
        expect(response.body).contain('Auth_token: ')
      });
    });
  });